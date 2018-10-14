package me.arkadzi.imho.domain.schedulers

import io.reactivex.Scheduler


interface SubscribeOn {
    fun scheduler(): Scheduler
}
