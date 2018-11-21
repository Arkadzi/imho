package me.arkadzi.imho.domain.model

import java.io.Serializable

class GraduateWork(
        val id: Long,
        var title: String,
        var description: String?,
        var labPriorityId: Long,
        var subsCount: Int,
        var owner: User? = null
): Serializable
