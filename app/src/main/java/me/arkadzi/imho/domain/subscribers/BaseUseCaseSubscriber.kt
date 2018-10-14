package me.arkadzi.imho.domain.subscribers

interface BaseUseCaseSubscriber<T> {

    fun onStart()
    fun onSuccess(value: T)
    fun onError(e: Throwable)
    fun onFinish()
}
