package me.arkadzi.imho.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.adapters.BaseHolder

class DiplomaHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
) : BaseHolder<GraduateWork>(inflater.inflate(R.layout.item_post, parent, false)),
        LayoutContainer {

    override fun bind(data: GraduateWork) {
        tvTitle.text = data.title
    }
}