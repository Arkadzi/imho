package me.arkadzi.imho.data.store

import me.arkadzi.imho.data.local.LocalStorage
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.User
import retrofit2.HttpException
import rx.Observable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class DataStoreProxy constructor(restApi: RestApi, storage: LocalStorage) : DataStore {
    private val remoteDataStore: DataStore
    private val localDataStore: DataStore

    init {
        remoteDataStore = RemoteDataStore(restApi, storage)
        localDataStore = LocalDataStore(storage)
    }

    override fun getPosts(): Observable<List<Post>> =
            remoteDataStore.getPosts()
                    .onErrorResumeNext { alternate(it, localDataStore.getPosts()) }

    override fun getCommentsByPost(postId: Int): Observable<List<Comment>> =
            remoteDataStore.getCommentsByPost(postId)

    override fun getUser(userId: Int): Observable<User> =
            remoteDataStore.getUser(userId)


    private fun alternate(it: Throwable?, observable: Observable<List<Post>>) =
            if (it is SocketTimeoutException
                    || it is ConnectException
                    || it is UnknownHostException) observable else Observable.error(it)
}