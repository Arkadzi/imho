package me.arkadzi.imho.data.local

import me.arkadzi.imho.domain.model.Post

interface LocalStorage {
    fun queryPosts(): List<Post>
    fun savePosts(posts: List<Post>)
}