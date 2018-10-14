package me.arkadzi.imho.domain.model
data class User(val id: Long,
                var email: String,
                var password: String,
                var firstName: String,
                var middleName: String,
                var lastName: String) {

}

enum class UserType {
    STUDENT, LECTURER
}