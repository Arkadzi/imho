package me.arkadzi.imho.domain.model

import java.io.Serializable

class LabPriority(
        val id: Long = 0,
        var title: String,
        var description: String,
        var labId: Long
) : Serializable