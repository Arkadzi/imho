package me.arkadzi.imho.presentation.views

import me.arkadzi.imho.domain.model.Post

interface PostView : ProgressView {
    fun renderList(data: List<Post>)
}