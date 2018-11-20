package me.arkadzi.imho.presentation.profile

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.usecase.GraduateWorksUseCase
import me.arkadzi.imho.presentation.base.BaseListPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.views.DiplomaListView
import javax.inject.Inject

@ActivityScope
class DiplomaPresenter @Inject constructor(messages: Messages,
                                           override val listUseCase: GraduateWorksUseCase
) : BaseListPresenter<GraduateWork, DiplomaListView<GraduateWork>>(messages, listUseCase) {

    override fun initUseCase(view: DiplomaListView<GraduateWork>) {
        listUseCase.setData(view.userId, view.isOwner)
    }
}