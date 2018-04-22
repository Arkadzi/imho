package me.arkadzi.imho.domain.usecase

import android.util.Log
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn

import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.subscriptions.Subscriptions

abstract class UseCase<T>(private val subscribeOn: SubscribeOn, private val observeOn: ObserveOn) {
    private var subscription = Subscriptions.empty()
    private var observable: Observable<T>? = null

    protected abstract fun useCaseObservable(): Observable<T>

    val isWorking: Boolean
        get() = observable != null

    fun execute(subscriber: Subscriber<T>) {
        Log.e("subscription", "subscribe $javaClass $observable")
        if (observable == null)
            observable = useCaseObservable()
                    .subscribeOn(subscribeOn.scheduler())
                    .observeOn(observeOn.scheduler())
                    .cache()
                    .doOnError { observable = null }
        subscription = observable!!.subscribe(subscriber)
    }

    fun unsubscribe() {
        Log.e("subscription", "unsubscribe $javaClass")
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

    fun stopExecution() {
        unsubscribe()
        observable = null
    }
}
