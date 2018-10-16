package me.arkadzi.imho.domain.model

class GraduateWork(
        var id: Int,
        var title: String,
        var date: Long,
        var description: String,
        var fullDescription: String,
        var course: Int,
        var ownerId: Int,
        var labPriorityId: Int
)
