package me.arkadzi.imho.domain.schedulers

import rx.Scheduler

interface ObserveOn {
    fun scheduler(): Scheduler
}
