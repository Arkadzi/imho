package me.arkadzi.imho.domain

import io.reactivex.Single
import me.arkadzi.imho.domain.model.User


interface Repository {
    fun login(login: String, password: String): Single<User>
}
