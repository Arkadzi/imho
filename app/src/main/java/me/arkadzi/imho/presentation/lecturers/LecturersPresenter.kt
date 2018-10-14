package me.arkadzi.imho.presentation.lecturers

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.usecase.LecturersUseCase
import me.arkadzi.imho.presentation.base.BaseListPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.views.BaseListView
import javax.inject.Inject

@ActivityScope
class LecturersPresenter @Inject constructor(messages: Messages,
                                             lecturersUseCase: LecturersUseCase
) : BaseListPresenter<Lecturer, BaseListView<Lecturer>>(messages, lecturersUseCase) {

}