package me.arkadzi.imho.domain

import io.reactivex.Single
import me.arkadzi.imho.domain.model.*


interface Repository {
    fun login(login: String, password: String): Single<User>
    fun getLabs(): Single<List<Lab>>
    fun getLecturers(labId: Long?): Single<List<Lecturer>>
    fun getLabPriorities(labId: Long): Single<List<LabPriority>>
    fun getGraduateWorks(userId: Long, owner: Boolean): Single<List<GraduateWork>>
    fun createGraduateWork(graduateWork: GraduateWork): Single<Boolean>
}
