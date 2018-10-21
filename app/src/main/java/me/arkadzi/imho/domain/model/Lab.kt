package me.arkadzi.imho.domain.model

import java.io.Serializable

data class Lab(
        var id: Long,
        var title: String
): Serializable {
    override fun toString(): String {
        return title
    }
}