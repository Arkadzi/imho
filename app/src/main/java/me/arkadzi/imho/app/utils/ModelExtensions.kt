package me.arkadzi.imho.app.utils

import me.arkadzi.imho.domain.model.*

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
        "студент $studentGroup"
    }