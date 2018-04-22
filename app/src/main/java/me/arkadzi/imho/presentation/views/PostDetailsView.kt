package me.arkadzi.imho.presentation.views

import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.PostInfo

interface PostDetailsView : ProgressView {
    fun renderInfo(data: PostInfo)
    fun getPost() : Post
}