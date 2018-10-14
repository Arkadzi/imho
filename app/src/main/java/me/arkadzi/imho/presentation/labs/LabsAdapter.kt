package me.arkadzi.imho.presentation.labs

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.presentation.adapters.BaseAdapter

class LabsAdapter(layoutInflater: LayoutInflater) : BaseAdapter<Lab>(layoutInflater) {
    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) =
            LabsHolder(inflater, parent)
}