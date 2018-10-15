package me.arkadzi.imho.presentation.lab_content

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.presentation.adapters.BaseAdapter

class LabPriorityAdapter(layoutInflater: LayoutInflater) : BaseAdapter<LabPriority>(layoutInflater) {
    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) =
            LabPriorityHolder(inflater, parent)
}