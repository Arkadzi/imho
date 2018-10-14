package me.arkadzi.imho.presentation.base


import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.presentation.views.ProgressView

open class ProgressPresenter<V : ProgressView>(messages: Messages) :
        BasePresenter<V>(messages),
        BaseProgressSubscriber.ProgressSubscriberListener {

    override fun onError(t: Throwable) {
        view?.hideProgress()
        val error = messages.getError(t)
        view?.showMessage(error)
    }

    override fun onCompleted() {
        view?.hideProgress()
    }

    override fun onStartLoading() {
        view?.showProgress()
    }
}
