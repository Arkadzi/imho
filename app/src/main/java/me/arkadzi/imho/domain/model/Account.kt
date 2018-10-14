package me.arkadzi.imho.domain.model

interface Account {
    fun getUser(): User?
    fun getToken(): String?
    fun isAuthorized(): Boolean
    fun saveUser(user: User)
    fun saveToken(token: String)
    fun clear()
}