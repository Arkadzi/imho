package me.arkadzi.imho.presentation.views

import me.arkadzi.imho.domain.model.User

interface ProfileView : ProgressView {
    fun renderUser(user: User)
}