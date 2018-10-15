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

    fun getLabs(): Single<List<Lab>> {
        return api.getLabs()
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
}
