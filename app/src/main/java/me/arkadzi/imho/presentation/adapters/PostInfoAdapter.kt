package me.arkadzi.imho.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.User1

class PostInfoAdapter(layoutInflater: LayoutInflater) : BaseHeaderAdapter<Comment, User1>(layoutInflater) {
    override fun generateHeaderHolder(inflater: LayoutInflater, parent: ViewGroup) = UserHolder(inflater, parent)

    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) = CommentHolder(inflater, parent)
}