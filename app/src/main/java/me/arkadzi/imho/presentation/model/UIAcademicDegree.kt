package me.arkadzi.imho.presentation.model

import me.arkadzi.imho.domain.model.AcademicDegree

class UIAcademicDegree(val title: String, val academicDegree: AcademicDegree) {
    override fun toString(): String {
        return title
    }
}