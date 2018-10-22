package me.arkadzi.imho.domain.model

import java.io.Serializable

open class User(val id: Long = 0,
                val email: String,
                val firstName: String,
                val middleName: String,
                val lastName: String,
                var studentGroup: String?,
                val avatarUrl: String?,
                val type: String

) : Serializable


const val TYPE_STUDENT = "STUDENT"
const val TYPE_LECTURER = "LECTURER"
