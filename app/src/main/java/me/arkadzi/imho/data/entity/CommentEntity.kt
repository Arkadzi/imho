package me.arkadzi.imho.data.entity

data class CommentEntity(
        var postId: Int,
        var id: Int,
        var name: String,
        var email: String,
        var body: String
)
