package me.arkadzi.imho.presentation.lecturers

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.adapters.BaseAdapter

class LecturersAdapter(layoutInflater: LayoutInflater) : BaseAdapter<Lecturer>(layoutInflater) {
    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) =
            LecturersHolder(inflater, parent)
}