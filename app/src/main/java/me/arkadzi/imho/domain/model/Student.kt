package me.arkadzi.imho.domain.model

class Student(val id: Long = 0,
              val email: String,
              val firstName: String,
              val middleName: String,
              val lastName: String,
              val studentGroup: String,
              val avatarUrl: String?)