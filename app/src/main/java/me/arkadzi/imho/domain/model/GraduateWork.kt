package me.arkadzi.imho.domain.model

import java.io.Serializable

class GraduateWork(
        val id: Long,
        var title: String,
        var description: String?,
        var labPriorityId: Long,
        var subsCount: Int,
        val owner: User? = null
): Serializable
