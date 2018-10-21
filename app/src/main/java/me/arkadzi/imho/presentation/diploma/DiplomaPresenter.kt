package me.arkadzi.imho.presentation.diploma

import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.domain.subscribers.BaseUseCaseSubscriber
import me.arkadzi.imho.domain.usecase.CreateGraduateWorkUseCase
import me.arkadzi.imho.domain.usecase.LabPrioritiesUseCase
import me.arkadzi.imho.domain.usecase.LabsUseCase
import me.arkadzi.imho.presentation.base.ProgressPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class DiplomaPresenter @Inject constructor(
        messages: Messages,
        val labsUseCase: LabsUseCase,
        val labPrioritiesUseCase: LabPrioritiesUseCase,
        val createGraduateWorkUseCase: CreateGraduateWorkUseCase
) : ProgressPresenter<DiplomaView>(messages) {
    override fun onCreate(view: DiplomaView) {
        super.onCreate(view)
        labsUseCase.execute(getLabsSubscriber())
    }

    fun onLabSelected(item: Lab) {
        view?.setLabPriorities(listOf())
        if (item.id >= 0) {
            labPrioritiesUseCase.stopExecution()
            labPrioritiesUseCase.setData(item.id)
            labPrioritiesUseCase.execute(getLabPrioritiesSubscriber())
        }
    }

    fun onCreateGraduateWork(graduateWork: GraduateWork) {
        createGraduateWorkUseCase.stopExecution()
        createGraduateWorkUseCase.setData(graduateWork)
        createGraduateWorkUseCase.execute(getCreateGraduateWorkSubscriber())
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
                view?.setLabs(value)
            }
        }
    }

    private fun getLabPrioritiesSubscriber(): BaseUseCaseSubscriber<List<LabPriority>> {
        return object : BaseProgressSubscriber<List<LabPriority>>(this) {
            override fun onSuccess(value: List<LabPriority>) {
                view?.setLabPriorities(value)
            }
        }
    }
}