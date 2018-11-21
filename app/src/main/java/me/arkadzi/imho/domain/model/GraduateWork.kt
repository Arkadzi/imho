package me.arkadzi.imho.domain.model

import java.io.Serializable

class GraduateWork(
        val id: Long,
        var title: String,
        var description: String?,
        var labPriorityId: Long,
        val subscribers: List<User>,
        var owner: User? = null
): Serializable
