package me.arkadzi.imho.domain.model

open class User(val id: Long = 0,
                val email: String,
                val password: String,
                val firstName: String,
                val middleName: String,
                val lastName: String,
                var studentGroup: String?,
                val type: String) {
    val avatar = "https://www.biography.com/.image/t_share/MTQzMjc4OTI3ODc4NTYzNjk0/christian-bale_gettyimages-504405052jpg.jpg"

}

enum class UserType {
    STUDENT, LECTURER
}