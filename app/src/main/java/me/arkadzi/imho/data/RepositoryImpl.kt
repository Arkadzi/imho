package me.arkadzi.imho.data

import io.reactivex.Single
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.*
import java.util.*

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

    override fun getLabs(lectureId: Long?): Single<List<Lab>> {
        return restApi.getLabs(lectureId)
    }

    override fun createGraduateWork(graduateWork: GraduateWork): Single<Boolean> {
        return restApi.createGraduateWork(graduateWork)
    }

    override fun getLabAndPriorities(priorityId: Long): Single<LabAndPriority> {
        return restApi.getLabAndPriorities(priorityId)
    }

    override fun offerWork(workId: Long, userId: Long, cancel: Boolean): Single<Boolean> {
        return restApi.offerWork(workId, userId, cancel)
    }

    override fun getLecturers(labId: Long?): Single<List<Lecturer>> {
        return restApi.getLecturers(labId)
    }

    override fun getGraduateWorks(email: String, owner: Boolean): Single<List<GraduateWork>> {
        return Single.just(if (owner) {
            listOf(
                    GraduateWork(1, "тема 1", "опис 1", 1, Random().nextInt(4)),
                    GraduateWork(2, "тема 2", "опис 2", 1, Random().nextInt(4)),
                    GraduateWork(3, "тема 3", "опис 3", 1, Random().nextInt(4)),
                    GraduateWork(4, "тема 4", "опис 4", 1, Random().nextInt(4))
            )
        } else {
            listOf(
                    GraduateWork(1, "тема A", "опис 1", 1, 1 + Random().nextInt(4)),
                    GraduateWork(2, "тема B", "опис 2", 1, 1 + Random().nextInt(4)),
                    GraduateWork(3, "тема C", "опис 3", 1, 1 + Random().nextInt(4)),
                    GraduateWork(4, "тема D", "опис 4", 1, 1 + Random().nextInt(4))
            )
        })
    }

    override fun getLabPriorities(labId: Long): Single<List<LabPriority>> {
        return restApi.getLabPriorities(labId)
    }

}