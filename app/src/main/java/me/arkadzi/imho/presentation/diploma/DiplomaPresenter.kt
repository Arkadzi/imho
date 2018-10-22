package me.arkadzi.imho.presentation.diploma

import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.*
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.domain.subscribers.BaseUseCaseSubscriber
import me.arkadzi.imho.domain.usecase.*
import me.arkadzi.imho.presentation.base.ProgressPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class DiplomaPresenter @Inject constructor(
        messages: Messages,
        val labsUseCase: LabsUseCase,
        val labPrioritiesUseCase: LabPrioritiesUseCase,
        val createGraduateWorkUseCase: CreateGraduateWorkUseCase,
        val getLabAndPriorityUseCase: GetLabAndPriorityUseCase,
        val lecturersUseCase: LecturersUseCase,
        val offerGraduateWorkUseCase: OfferGraduateWorkUseCase
) : ProgressPresenter<DiplomaView>(messages) {
    private var lab: Lab? = null

    override fun onCreate(view: DiplomaView) {
        super.onCreate(view)
        if (view.isCreatingNew) {
            labsUseCase.execute(getLabsSubscriber())
        } else {
            val graduateWork = view.graduateWork!!
            getLabAndPriorityUseCase.setData(graduateWork.labPriorityId)
            getLabAndPriorityUseCase.execute(getLabAndPrioritySubscriber())
            view.setDiploma(graduateWork)
        }
    }

    private fun getLabAndPrioritySubscriber(): BaseUseCaseSubscriber<LabAndPriority> {
        return object : BaseProgressSubscriber<LabAndPriority>(this) {
            override fun onSuccess(value: LabAndPriority) {
                lab = value.lab
                view?.setLabs(listOf(value.lab))
                view?.setLabPriorities(listOf(value.priority))
            }
        }
    }

    fun onLabSelected(item: Lab) {
        if (view?.isCreatingNew == true) {
            view?.setLabPriorities(listOf())
            if (item.id >= 0) {
                labPrioritiesUseCase.stopExecution()
                labPrioritiesUseCase.setData(item.id)
                labPrioritiesUseCase.execute(getLabPrioritiesSubscriber())
            }
        }
    }

    fun onCreateGraduateWork(graduateWork: GraduateWork) {
        createGraduateWorkUseCase.stopExecution()
        createGraduateWorkUseCase.setData(graduateWork)
        createGraduateWorkUseCase.execute(getCreateGraduateWorkSubscriber())
    }

    fun onOfferClick() {
        lecturersUseCase.setData(lab!!.id)
        lecturersUseCase.execute(getLecturersSubscriber())
    }

    fun onLecturerChosen(user: Lecturer) {
        val graduateWork = view?.graduateWork!!
        offerGraduateWorkUseCase.setData(graduateWork.id, user.id, cancel = false)
        offerGraduateWorkUseCase.execute(getOfferSubscriber())
    }

    private fun getOfferSubscriber(): BaseUseCaseSubscriber<Boolean> {
        return object : BaseProgressSubscriber<Boolean>(this) {
            override fun onSuccess(value: Boolean) {
                showMessage(messages.getMessage(R.string.mes_offered_successfully))
                view?.close()
            }
        }
    }

    private fun getCreateGraduateWorkSubscriber(): BaseUseCaseSubscriber<Boolean> {
        return object : BaseProgressSubscriber<Boolean>(this) {
            override fun onSuccess(value: Boolean) {
                showMessage(messages.getMessage(R.string.mes_created_successfully))
                view?.close()
            }
        }
    }

    private fun getLabsSubscriber(): BaseUseCaseSubscriber<List<Lab>> {
        return object : BaseProgressSubscriber<List<Lab>>(this) {
            override fun onSuccess(value: List<Lab>) {
                val list = value.toMutableList().apply {
                    add(0, Lab(-1, messages.getMessage(R.string.hint_not_selected)))
                }
                view?.setLabs(list)
            }
        }
    }

    private fun getLabPrioritiesSubscriber(): BaseUseCaseSubscriber<List<LabPriority>> {
        return object : BaseProgressSubscriber<List<LabPriority>>(this) {
            override fun onSuccess(value: List<LabPriority>) {
                val list = value.toMutableList().apply {
                    add(0, LabPriority(-1, messages.getMessage(R.string.hint_not_selected), "", -1))
                }
                view?.setLabPriorities(list)
            }
        }
    }

    private fun getLecturersSubscriber(): BaseUseCaseSubscriber<List<Lecturer>> {
        return object : BaseProgressSubscriber<List<Lecturer>>(this) {
            override fun onSuccess(value: List<Lecturer>) {
                view?.showLecturers(value)
            }
        }
    }
}