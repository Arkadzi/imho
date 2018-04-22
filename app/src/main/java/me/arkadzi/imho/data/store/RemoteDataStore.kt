package me.arkadzi.imho.data.store

import me.arkadzi.imho.data.local.LocalStorage
import me.arkadzi.imho.data.mapper.Mappers
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.User
import rx.Observable

class RemoteDataStore(private val api: RestApi, private val storage: LocalStorage) : DataStore {
    override fun getPosts(): Observable<List<Post>> {
        return api.getPosts()
                .flatMapIterable { it }
                .map { Mappers.postMapper.map(it) }
                .toList()
                .doOnNext { storage.savePosts(it) }
    }

    override fun getCommentsByPost(postId: Int): Observable<List<Comment>> {
        return api.getComments(postId)
                .flatMapIterable { it }
                .map { Mappers.commentMapper.map(it) }
                .toList()
    }

    override fun getUser(userId: Int): Observable<User> {
        return api.getUser(userId)
                .map { Mappers.userMapper.map(it) }
    }
}