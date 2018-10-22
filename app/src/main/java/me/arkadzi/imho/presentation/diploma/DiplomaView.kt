package me.arkadzi.imho.presentation.diploma

import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.views.ProgressView

interface DiplomaView: ProgressView {
    val isCreatingNew: Boolean
    val graduateWork: GraduateWork?
    fun setLabs(labs: List<Lab>)
    fun setLabPriorities(priorities: List<LabPriority>)
    fun close()
    fun setDiploma(graduateWork: GraduateWork)
    fun showLecturers(value: List<Lecturer>)
}