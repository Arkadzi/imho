package me.arkadzi.imho.domain.model

class Lecturer(id: Long,
               email: String,
               password: String,
               firstName: String,
               middleName: String,
               lastName: String
) : User(id, email, password, firstName, middleName, lastName)