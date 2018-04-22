package me.arkadzi.imho.data.local

import me.arkadzi.imho.domain.model.Post

class RamStorage : LocalStorage {
    val posts = mutableListOf<Post>()

    override fun queryPosts(): List<Post> {
        return posts.toMutableList()
    }

    override fun savePosts(posts: List<Post>) {
        this.posts.clear()
        this.posts += posts
    }
}