package me.arkadzi.imho.domain.model

class Lecturer(val id: Long = 0,
               val email: String,
               val firstName: String,
               val middleName: String,
               val lastName: String,
               val grade: String = "ктн",
               val avatarUrl: String?) {
}