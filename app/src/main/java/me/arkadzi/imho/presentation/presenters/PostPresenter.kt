package me.arkadzi.imho.presentation.presenters

import me.arkadzi.imho.presentation.views.PostView

interface PostPresenter : Presenter<PostView> {
    fun onRefresh()
}
