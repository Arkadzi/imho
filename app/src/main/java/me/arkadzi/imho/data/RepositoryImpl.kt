package me.arkadzi.imho.data

import me.arkadzi.imho.data.store.DataStore
import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.PostInfo
import me.arkadzi.imho.domain.model.User
import rx.Observable

class RepositoryImpl(private val dataStore: DataStore) : Repository {
    override fun getPosts() = dataStore.getPosts()

    override fun getPostInfo(post: Post): Observable<PostInfo> {
        return dataStore.getCommentsByPost(post.id)
                .flatMap({ dataStore.getUser(post.userId) }, { comments: List<Comment>, user: User -> PostInfo(user, comments) })
    }

}