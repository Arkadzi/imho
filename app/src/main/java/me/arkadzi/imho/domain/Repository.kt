package me.arkadzi.imho.domain

import io.reactivex.Single
import me.arkadzi.imho.domain.model.*


interface Repository {
    fun login(login: String, password: String): Single<User>
    fun getLabs(lectureId: Long?): Single<List<Lab>>
    fun getLecturers(labId: Long?): Single<List<Lecturer>>
    fun getLabPriorities(labId: Long): Single<List<LabPriority>>
    fun getGraduateWorks(email: String, owner: Boolean): Single<List<GraduateWork>>
    fun createGraduateWork(graduateWork: GraduateWork): Single<Boolean>
    fun getLabAndPriorities(priorityId: Long): Single<LabAndPriority>
    fun offerWork(workId: Long, userId: Long, cancel: Boolean): Single<Boolean>
}
