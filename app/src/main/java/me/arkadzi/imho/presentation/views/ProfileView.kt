package me.arkadzi.imho.presentation.views

import me.arkadzi.imho.domain.model.User

interface ProfileView : ProgressView {
    val user: User
    fun renderUser(user: User)
}