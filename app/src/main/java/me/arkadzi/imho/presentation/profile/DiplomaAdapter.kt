package me.arkadzi.imho.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.adapters.BaseAdapter

class DiplomaAdapter(layoutInflater: LayoutInflater) : BaseAdapter<GraduateWork>(layoutInflater) {
    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) =
            DiplomaHolder(inflater, parent)
}