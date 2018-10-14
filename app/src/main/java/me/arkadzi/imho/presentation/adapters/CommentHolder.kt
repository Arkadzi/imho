package me.arkadzi.imho.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_comment.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Comment

class CommentHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseHolder<Comment>(inflater.inflate(R.layout.item_comment, parent, false)),
        LayoutContainer {

    override fun bind(data: Comment) {
        tvName.text = data.name
        tvBody.text = data.body
    }

}