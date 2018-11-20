package me.arkadzi.imho.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_diploma.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.presentation.adapters.BaseHolder

class DiplomaHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
) : BaseHolder<GraduateWork>(inflater.inflate(R.layout.item_diploma, parent, false)),
        LayoutContainer {

    override fun bind(data: GraduateWork) {
        tvTitle.text = data.title
        tvProposedTo.text = "${context.getString(R.string.hint_proposed_to)}: ${data.subsCount}"
    }
}