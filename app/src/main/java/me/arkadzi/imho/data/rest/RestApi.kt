package me.arkadzi.imho.data.rest

import java.util.concurrent.TimeUnit


class RestApi(private val api: RetrofitApi) {

    fun getPosts() = api.getPosts()/*.delay(2000,  TimeUnit.MILLISECONDS)*/

    fun getComments(postId: Int) = api.getComments(postId)

    fun getUser(userId: Int) = api.getUser(userId)
}
