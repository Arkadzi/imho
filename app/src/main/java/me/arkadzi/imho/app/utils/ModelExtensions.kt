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
    return false/*subscribers.any { it.recipientId == user.id }*/
}

fun GraduateWork.isUserOwner(user: User): Boolean {
    return this.owner!!.id == user.id
}

fun User.avatar() = when (email) {
    "karpenko.eugene@gmail.com" -> "https://scontent.fiev10-1.fna.fbcdn.net/v/t1.0-1/c0.0.160.160/p160x160/18119535_1311624472286812_1590395396869357411_n.jpg?_nc_cat=104&_nc_ht=scontent.fiev10-1.fna&oh=994fed0ece5a723ce3012447dc51e7bc&oe=5C6A9758"
    "ark@mail.me" -> "https://scontent.fiev10-1.fna.fbcdn.net/v/t1.0-1/p160x160/36177222_1779391162147519_6289464277635956736_n.jpg?_nc_cat=106&_nc_ht=scontent.fiev10-1.fna&oh=7ecb759161d335cd95f274eeca61b567&oe=5CB1C30E"
    else -> avatarUrl
}

fun User.grade() = when (email) {
//    "karpenko.eugene@gmail.com" ->
    "ark@mail.me" -> "студент 6 курсу ТВ-71мп"
    else -> "к.т.н, доцент"
}

fun User.getRedText() = when(email) {
    "karpenko.eugene@gmail.com" -> "бакалаврів набрано"
    "ark@mail.me" -> "тему не підтверджено"
    else -> null
}

fun User.getGreenText() = when(email) {
    "karpenko.eugene@gmail.com" -> "магістрів залишилось: 2"
    "ark@mail.me" -> null
    else -> null
}