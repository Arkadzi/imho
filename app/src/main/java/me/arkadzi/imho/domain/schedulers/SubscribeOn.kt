package me.arkadzi.imho.domain.schedulers

import rx.Scheduler

interface SubscribeOn {
    fun scheduler(): Scheduler
}
