package me.arkadzi.imho.domain.model

import java.io.Serializable

class GraduateWork(
        var title: String,
        var description: String?,
        var academicDegree: AcademicDegree,
        var labPriorityId: Long,
        var subscribers:List<GraduateWorkUserRelationDto>
): Serializable
