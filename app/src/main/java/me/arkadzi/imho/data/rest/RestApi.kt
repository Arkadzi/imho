package me.arkadzi.imho.data.rest


class RestApi(private val api: RetrofitApi) {

    fun getPosts() = api.getPosts()

    fun getComments(postId: Int) = api.getComments(postId)

    fun getUser(userId: Int) = api.getUser(userId)
}
