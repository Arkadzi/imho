package me.arkadzi.imho.domain.model

data class Post(
        var userId: Int,
        var id: Int,
        var title: String,
        var body: String
)