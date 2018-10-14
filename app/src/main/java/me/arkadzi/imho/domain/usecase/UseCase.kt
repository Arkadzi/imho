package me.arkadzi.imho.domain.usecase

import android.util.Log
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposables
import io.reactivex.functions.BiConsumer
import io.reactivex.internal.functions.Functions
import io.reactivex.internal.observers.BiConsumerSingleObserver
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import me.arkadzi.imho.domain.subscribers.BaseUseCaseSubscriber


abstract class UseCase<T>(private val subscribeOn: SubscribeOn, private val observeOn: ObserveOn) {
    private var subscription = Disposables.empty()
    private var observable: Single<T>? = null

    protected abstract fun useCaseObservable(): Single<T>

    val isWorking: Boolean
        get() = observable != null

    fun execute(subscriber: BaseUseCaseSubscriber<T>) {
        if (observable == null)
            observable = useCaseObservable()
                    .subscribeOn(subscribeOn.scheduler())
                    .observeOn(observeOn.scheduler())
                    .cache()
                    .doFinally { observable = null  }
                    .doOnSubscribe {
                        subscriber.onStart()
                    }
                    .doOnSuccess {
                        subscriber.onSuccess(it)
                    }
                    .doAfterSuccess{
                        subscriber.onFinish()
                    }
                    .doOnError {
                        subscriber.onError(it)
                    }
        subscription = observable!!.subscribe(Functions.emptyConsumer(), Functions.emptyConsumer())
    }

    fun unsubscribe() {
        Log.e("subscription", "unsubscribe $javaClass")
        if (!subscription.isDisposed) {
            subscription.dispose()
        }
    }

    fun stopExecution() {
        unsubscribe()
        observable = null
    }
}
