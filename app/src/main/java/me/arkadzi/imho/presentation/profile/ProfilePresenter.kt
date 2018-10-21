package me.arkadzi.imho.presentation.profile

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.Account
import me.arkadzi.imho.presentation.base.ProgressPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.views.ProfileView
import javax.inject.Inject

@ActivityScope
class ProfilePresenter @Inject constructor(
        val account: Account,
        messages: Messages
) : ProgressPresenter<ProfileView>(messages) {
    override fun onCreate(view: ProfileView) {
        super.onCreate(view)
        view.renderUser(view.user)
    }
}