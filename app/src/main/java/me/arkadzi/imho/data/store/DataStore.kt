package me.arkadzi.imho.data.store

import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.User
import rx.Observable

interface DataStore {

    fun getPosts(): Observable<List<Post>>

    fun getCommentsByPost(postId: Int): Observable<List<Comment>>

    fun getUser(userId: Int): Observable<User>
}
