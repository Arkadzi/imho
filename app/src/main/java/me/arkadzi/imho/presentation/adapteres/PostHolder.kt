package me.arkadzi.imho.presentation.adapteres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Post

class PostHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseHolder<Post>(inflater.inflate(R.layout.item_post, parent, false)),
        LayoutContainer {

    override fun bind(data: Post) {
        tvTitle.text = data.title
        tvPost.text = data.body
    }

}