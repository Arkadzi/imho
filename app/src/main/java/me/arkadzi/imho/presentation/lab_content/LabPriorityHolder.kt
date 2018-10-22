package me.arkadzi.imho.presentation.lab_content

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_lab.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.presentation.adapters.BaseHolder

class LabPriorityHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
) : BaseHolder<LabPriority>(inflater.inflate(R.layout.item_lab, parent, false)),
        LayoutContainer {

    override fun bind(data: LabPriority) {
        ivIcon.setImageResource(R.drawable.ic_priority)
        tvTitle.text = data.title
    }
}