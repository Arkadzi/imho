package me.arkadzi.imho.presentation.lecturers

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.adapters.BaseHolder

class LecturersHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
) : BaseHolder<Lecturer>(inflater.inflate(R.layout.item_post, parent, false)),
        LayoutContainer {

    override fun bind(data: Lecturer) {
        tvTitle.text = data.fullName
    }

    val Lecturer.fullName
        get() = "$lastName $firstName $middleName"
}