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
        val smak = User(101, "smakovskiy-ds@apeps.kiev.ua", "Денис", "Сергійович", "Смаковський", null,"http://apeps.kiev.ua/images/lecturer/profile/smakovskiy-ds.jpg", TYPE_LECTURER)
        val tyh = User(102, "tikhokhod@mail.ru",  "Володимир", "Олександрович", "Тихоход", null,"http://apeps.kpi.ua/images/teachers/Tyhohod.jpg", TYPE_LECTURER)
        val karp = User(103, "karpenko.eugene@gmail.com", "Євген", "Юрійович", "Карпенко", null,"https://scontent.fiev10-1.fna.fbcdn.net/v/t1.0-1/c0.0.160.160/p160x160/18119535_1311624472286812_1590395396869357411_n.jpg?_nc_cat=104&_nc_ht=scontent.fiev10-1.fna&oh=994fed0ece5a723ce3012447dc51e7bc&oe=5C6A9758", TYPE_LECTURER)
        return Single.just(if (owner) {
            listOf(
                    GraduateWork(1, "тема 1", "опис 1", 7, listOf(karp, tyh, smak)),
                    GraduateWork(2, "тема 2", "опис 2", 7, listOf(karp, tyh)),
                    GraduateWork(3, "тема 3", "опис 3", 8, listOf(karp, smak)),
                    GraduateWork(4, "тема 4", "опис 4", 8, listOf(karp))
            )
        } else {
            listOf(
                    GraduateWork(1, "тема A", "опис 1", 7, listOf(karp, tyh)),
                    GraduateWork(2, "тема B", "опис 2", 8, listOf(karp)),
                    GraduateWork(3, "тема C", "опис 3", 9, listOf(karp, smak)),
                    GraduateWork(4, "тема D", "опис 4", 10, listOf(karp))
            )
        })
    }

    override fun getLabPriorities(labId: Long): Single<List<LabPriority>> {
        return restApi.getLabPriorities(labId)
    }

}