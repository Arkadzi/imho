package me.arkadzi.imho.domain.model

open class User(val id: Long = 0,
                val email: String,
                val firstName: String,
                val middleName: String,
                val lastName: String,
                var studentGroup: String?,
                val type: String) {
    val avatar
        get() = "https://cs5.pikabu.ru/post_img/2015/10/09/5/1444376651_2121134463.jpg"
}


const val TYPE_STUDENT = "STUDENT"
const val TYPE_LECTURER = "LECTURER"
