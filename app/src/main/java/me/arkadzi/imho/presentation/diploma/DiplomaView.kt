package me.arkadzi.imho.presentation.diploma

import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.presentation.views.ProgressView

interface DiplomaView: ProgressView {
    fun setLabs(labs: List<Lab>)
    fun setLabPriorities(labs: List<LabPriority>)
    fun close()
}