package me.arkadzi.imho.data.store

import me.arkadzi.imho.data.local.LocalStorage
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.User
import rx.Observable

class LocalDataStore(val storage: LocalStorage) : DataStore {
    override fun getPosts(): Observable<List<Post>> {
        return Observable.defer { Observable.just(storage.queryPosts()) }
    }

    override fun getCommentsByPost(postId: Int): Observable<List<Comment>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(userId: Int): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}