package me.arkadzi.imho.presentation.labs

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.usecase.LabsUseCase
import me.arkadzi.imho.presentation.base.BaseListPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.views.BaseListView
import javax.inject.Inject

@ActivityScope
class LaboratoriesPresenter @Inject constructor(messages: Messages,
                                                labsUseCase: LabsUseCase
) : BaseListPresenter<Lab, BaseListView<Lab>>(messages, labsUseCase) {

}