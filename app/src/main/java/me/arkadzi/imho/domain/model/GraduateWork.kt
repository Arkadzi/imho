package me.arkadzi.imho.domain.model

import java.io.Serializable

class GraduateWork(
        val id: Long,
        var title: String,
        var description: String?,
        var academicDegree: AcademicDegree,
        var labPriorityId: Long,
        var subscribers:List<GraduateWorkUserRelationDto>,
        val owner: User? = null
): Serializable
