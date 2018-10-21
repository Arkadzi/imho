package me.arkadzi.imho.domain.model

class Lecturer(val id: Long = 0,
               val email: String,
               val firstName: String,
               val middleName: String,
               val lastName: String,
               val grade: String = "ктн"
) {
    val avatar
        get() = "https://cs5.pikabu.ru/post_img/2015/10/09/5/1444376651_2121134463.jpg"
}