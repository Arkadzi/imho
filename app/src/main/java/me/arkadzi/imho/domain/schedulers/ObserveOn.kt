package me.arkadzi.imho.domain.schedulers

import io.reactivex.Scheduler


interface ObserveOn {
    fun scheduler(): Scheduler
}
