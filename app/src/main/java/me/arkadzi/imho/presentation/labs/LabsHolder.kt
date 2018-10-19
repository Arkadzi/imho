package me.arkadzi.imho.presentation.labs

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.presentation.adapters.BaseHolder

class LabsHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
) : BaseHolder<Lab>(inflater.inflate(R.layout.item_lab, parent, false)),
        LayoutContainer {

    override fun bind(data: Lab) {
        tvTitle.text = data.title
    }
}