package me.arkadzi.imho.presentation.adapteres

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Post

class PostsAdapter(layoutInflater: LayoutInflater)  : BaseAdapter<Post>(layoutInflater) {
    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) = PostHolder(inflater, parent)
}