package me.arkadzi.imho.data

import io.reactivex.Single
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.*

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

    override fun createGraduateWork(graduateWork: GraduateWork): Single<Boolean> {
        return restApi.createGraduateWork(graduateWork)
    }

    override fun getLabAndPriorities(priorityId: Long): Single<LabAndPriority> {
        return restApi.getLabAndPriorities(priorityId)
    }

    override fun getLecturers(labId: Long?): Single<List<Lecturer>> {
        return restApi.getLecturers(labId)
    }

    override fun getGraduateWorks(userId: Long, owner: Boolean): Single<List<GraduateWork>> {
        return if (owner) {
            restApi.getOwnGraduateWorks(userId)
        } else {
            restApi.getOfferedGraduateWorks(userId)
        }
    }

    override fun getLabPriorities(labId: Long): Single<List<LabPriority>> {
        return restApi.getLabPriorities(labId)
    }

}