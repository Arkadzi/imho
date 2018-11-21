package me.arkadzi.imho.presentation.views

import me.arkadzi.imho.domain.model.User

interface DiplomaListView<T>: BaseListView<T> {
    val user: User
    val isOwner: Boolean
}