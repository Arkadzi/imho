package me.arkadzi.imho.presentation.lab_content

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.domain.usecase.LabPrioritiesUseCase
import me.arkadzi.imho.presentation.base.BaseListPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.views.BaseListView
import me.arkadzi.imho.presentation.views.LabContentView
import javax.inject.Inject

@ActivityScope
class LabPriorityPresenter @Inject constructor(messages: Messages,
                                               override val listUseCase: LabPrioritiesUseCase
) : BaseListPresenter<LabPriority, LabContentView<LabPriority>>(messages, listUseCase) {

    override fun initUseCase(view: LabContentView<LabPriority>) {
        listUseCase.setData(view.labId!!)
    }
}