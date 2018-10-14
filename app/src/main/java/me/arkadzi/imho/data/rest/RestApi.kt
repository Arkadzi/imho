package me.arkadzi.imho.data.rest

import io.reactivex.Single
import me.arkadzi.imho.domain.model.Credentials
import me.arkadzi.imho.domain.model.User


class RestApi(private val api: RetrofitApi) {
    fun login(login: String, password: String): Single<String> {
        return api.login(Credentials(login, password))
                .map { it.headers()["Authorization"]!! }
    }

    fun getSelf(token: String): Single<User> {
        return api.getSelf(token)
    }
}
