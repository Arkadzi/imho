package me.arkadzi.imho.domain.subscribers

import android.util.Log

open class BaseProgressSubscriber<T>(
        private var listener: ProgressSubscriberListener?
) : BaseUseCaseSubscriber<T> {
    override fun onSuccess(value: T) {
        Log.e("useCase", "onNext $value")
    }

    override fun onError(e: Throwable) {
        Log.e("useCase", "onError $e")
        listener?.onError(e)
        listener = null
    }

    override fun onFinish() {
        Log.e("useCase", "onComplete")
        listener?.onCompleted()
        listener = null
    }

    override fun onStart() {
        listener?.onStartLoading()
    }

    interface ProgressSubscriberListener {
        fun onError(t: Throwable)

        fun onCompleted()

        fun onStartLoading()
    }
}