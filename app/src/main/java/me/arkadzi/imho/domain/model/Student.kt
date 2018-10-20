package me.arkadzi.imho.domain.model

class Student(val id: Long = 0,
              val email: String,
              val firstName: String,
              val middleName: String,
              val lastName: String,
              val studentGroup: String
) {
    val avatar = "https://www.biography.com/.image/t_share/MTQzMjc4OTI3ODc4NTYzNjk0/christian-bale_gettyimages-504405052jpg.jpg"
}