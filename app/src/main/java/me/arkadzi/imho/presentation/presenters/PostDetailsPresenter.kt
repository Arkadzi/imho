package me.arkadzi.imho.presentation.presenters

import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.presentation.views.PostDetailsView

interface PostDetailsPresenter : Presenter<PostDetailsView> {
    fun onRefresh(post: Post)

}
