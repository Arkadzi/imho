package me.arkadzi.imho.presentation.base


import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.presentation.presenters.Presenter
import me.arkadzi.imho.presentation.views.View


abstract class BasePresenter<V : View>(val messages: Messages) : Presenter<V> {
    protected var view: V? = null

    override fun onCreate(view: V) {
        this.view = view
    }

    override fun onRelease() {
        view = null
    }

    protected fun showMessage(message: String) {
        view?.showMessage(message)
    }
}
