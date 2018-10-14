package me.arkadzi.imho.data.rest

import io.reactivex.Single
import me.arkadzi.imho.domain.model.Credentials
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.model.User


class RestApi(private val api: RetrofitApi) {
    fun login(login: String, password: String): Single<String> {
        return api.login(Credentials(login, password))
                .map { it.headers()["Authorization"]!! }
    }

    fun getSelf(token: String): Single<User> {
        return api.getSelf(token)
    }

    fun getLabs(): Single<List<Lab>> {
        return api.getLabs()
    }

    fun getLecturers(): Single<List<Lecturer>> {
        return api.getLecturers()
    }
}
