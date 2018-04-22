package me.arkadzi.imho.domain.subscribers


import android.util.Log

class BaseProgressSubscriber<T>(private var listener: ProgressSubscriberListener?) : BaseUseCaseSubscriber<T>() {

    override fun onStart() {
        listener?.onStartLoading()
    }

    override fun onCompleted() {
        Log.e("useCase", "onComplete")
        listener?.onCompleted()
        listener = null
    }

    override fun onError(e: Throwable) {
        Log.e("useCase", "onError $e")
        listener?.onError(e)
        listener = null
    }

    override fun onNext(response: T) {
        Log.e("useCase", "onNext $response")
    }

    interface ProgressSubscriberListener {
        fun onError(t: Throwable)

        fun onCompleted()

        fun onStartLoading()
    }
}