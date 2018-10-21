package me.arkadzi.imho.domain.model

enum class GraduateWorkStatus {
    PENDING, // student can cancel
    SUBMITTED, // student can't cancel
    APPROVED, // student can't change theme
}