package me.arkadzi.imho.presentation.adapteres

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.User

class PostInfoAdapter(layoutInflater: LayoutInflater) : BaseHeaderAdapter<Comment, User>(layoutInflater) {
    override fun generateHeaderHolder(inflater: LayoutInflater, parent: ViewGroup) = UserHolder(inflater, parent)

    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) = CommentHolder(inflater, parent)
}