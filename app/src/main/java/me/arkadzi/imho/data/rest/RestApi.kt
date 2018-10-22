package me.arkadzi.imho.data.rest

import io.reactivex.Single
import me.arkadzi.imho.domain.model.*


class RestApi(private val api: RetrofitApi) {
    fun login(login: String, password: String): Single<String> {
        return api.login(Credentials(login, password))
                .map { it.headers()["Authorization"]!! }
    }

    fun getSelf(token: String): Single<User> {
        return api.getSelf(token)
    }

    fun getLabs(lectureId: Long?): Single<List<Lab>> {
        return if (lectureId != null) {
            api.getLabsByLecturers(lectureId)
        } else {
            api.getLabs()
        }
    }

    fun getLecturers(labId: Long?): Single<List<Lecturer>> {
        return if (labId != null) {
            api.getLecturersByLab(labId)
        } else {
            api.getLecturers()
        }
    }


    fun getLabPriorities(labId: Long): Single<List<LabPriority>> {
        return api.getLabPriorities(labId)
    }

    fun getOwnGraduateWorks(userId: Long): Single<List<GraduateWork>> {
        return api.getOwnGraduateWorks(userId)
    }

    fun getOfferedGraduateWorks(userId: Long): Single<List<GraduateWork>> {
        return api.getOfferedGraduateWorks(userId)
    }

    fun createGraduateWork(graduateWork: GraduateWork): Single<Boolean> {
        return api.createGraduateWork(graduateWork).map { true }
    }

    fun getLabAndPriorities(priorityId: Long): Single<LabAndPriority> {
        return api.getLabAndPriorities(priorityId)
    }

    fun offerWork(workId: Long, userId: Long, cancel: Boolean): Single<Boolean> {
        return api.offerWork(workId, userId, cancel).map { true }
    }
}
