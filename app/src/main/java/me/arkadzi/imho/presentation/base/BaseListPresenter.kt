package me.arkadzi.imho.presentation.base

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.domain.usecase.ListUseCase
import me.arkadzi.imho.presentation.views.BaseListView

abstract class BaseListPresenter<D, V : BaseListView<D>>(
        messages: Messages,
        open val listUseCase: ListUseCase<D>
) : ProgressPresenter<V>(messages) {

    override fun onCreate(view: V) {
        super.onCreate(view)
        initUseCase(view)
        listUseCase.execute(getSubscriber())
    }

    override fun onRelease() {
        listUseCase.stopExecution()
        super.onRelease()
    }

    protected open fun initUseCase(view: V) {

    }

    private fun getSubscriber() : BaseProgressSubscriber<List<D>> {
        return object : BaseProgressSubscriber<List<D>>(this) {
            override fun onSuccess(value: List<D>) {
                super.onSuccess(value)
                view?.setData(value)
            }
        }
    }
}