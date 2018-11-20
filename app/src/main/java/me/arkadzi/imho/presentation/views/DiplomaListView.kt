package me.arkadzi.imho.presentation.views

interface DiplomaListView<T>: BaseListView<T> {
    val userId: String
    val isOwner: Boolean
}