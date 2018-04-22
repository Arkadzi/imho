package me.arkadzi.imho.presentation.presenters

import me.arkadzi.imho.presentation.views.View

interface Presenter<V: View> {
    fun onCreate(view: V)
    fun onRelease()
}