package me.arkadzi.imho.data.rest


import me.arkadzi.imho.data.entity.CommentEntity
import me.arkadzi.imho.data.entity.PostEntity
import me.arkadzi.imho.data.entity.UserEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface RetrofitApi {

    @GET("posts")
    fun getPosts(): Observable<List<PostEntity>>

    @GET("comments")
    fun getComments(@Query("postId") postId: Int): Observable<List<CommentEntity>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Observable<UserEntity>
}
