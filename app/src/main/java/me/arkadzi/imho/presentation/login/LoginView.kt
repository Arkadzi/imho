package me.arkadzi.imho.presentation.login

import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.views.ProgressView

interface LoginView: ProgressView {
    fun goToProfile(user: User)
}