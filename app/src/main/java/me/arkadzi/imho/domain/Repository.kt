package me.arkadzi.imho.domain

import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.PostInfo
import rx.Observable


interface Repository {

    fun getPosts(): Observable<List<Post>>

    fun getPostInfo(post: Post): Observable<PostInfo>
}
