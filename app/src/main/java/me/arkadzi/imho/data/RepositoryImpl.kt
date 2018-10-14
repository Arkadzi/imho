package me.arkadzi.imho.data

import io.reactivex.Single
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Account
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.model.User

class RepositoryImpl(
        private val restApi: RestApi,
        private val account: Account
) : Repository {
    override fun login(login: String, password: String): Single<User> {
        return restApi.login(login, password)
                .toObservable()
                .flatMap(
                        { token -> restApi.getSelf(token).toObservable() },
                        { token, user ->
                            account.saveToken(token)
                            account.saveUser(user)
                            return@flatMap user
                        }
                )
                .singleOrError()
    }

    override fun getLabs(): Single<List<Lab>> {
        return restApi.getLabs()
    }

    override fun getLecturers(): Single<List<Lecturer>> {
        return restApi.getLecturers()
    }
}