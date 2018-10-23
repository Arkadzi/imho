package me.arkadzi.imho.app.utils

import android.content.Context
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.*
import me.arkadzi.imho.presentation.model.UIAcademicDegree

val User.isStudent
    get() = type.equals(TYPE_STUDENT, ignoreCase = true)

val User.isLecturer
    get() = type.equals(TYPE_LECTURER, ignoreCase = true)

val User.fullName
    get() = "$lastName $firstName $middleName"

val Lecturer.fullName
    get() = "$lastName $firstName $middleName"

val Student.fullName
    get() = "$lastName $firstName $middleName"

val User.grade
    get() = if (isLecturer) {
        "ктн"
    } else {
        "студент ${studentGroup ?: ""}"
    }

fun Lecturer.asUser() =
        User(id, email, firstName, middleName, lastName, null, avatarUrl, TYPE_LECTURER)

fun AcademicDegree.mapToUI(context: Context) = UIAcademicDegree(
        when (this) {
            AcademicDegree.BACHELOR -> context.getString(R.string.hint_bachelor)
            AcademicDegree.MASTER -> context.getString(R.string.hint_master)
        },
        this)

fun List<AcademicDegree>.mapToUI(context: Context) = this.map { it.mapToUI(context) }

fun GraduateWork.isUserSubscribed(user: User): Boolean {
    return subscribers.any { it.recipientId == user.id }
}

fun GraduateWork.isUserOwner(user: User): Boolean {
    return this.owner!!.id == user.id
}