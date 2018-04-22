package me.arkadzi.imho.presentation.presenters

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.domain.usecase.GetPostsUseCase
import me.arkadzi.imho.presentation.views.PostView

class PostPresenterImpl(messages: Messages, private val useCase: GetPostsUseCase) :
        ProgressPresenter<PostView>(messages),
        PostPresenter {

    override fun onCreate(view: PostView) {
        super.onCreate(view)
        useCase.execute(getPostsSubscriber())
    }

    override fun onRelease() {
        useCase.unsubscribe()
        super.onRelease()
    }

    override fun onRefresh() {
        useCase.stopExecution()
        useCase.execute(getPostsSubscriber())
    }

    private fun getPostsSubscriber() = object : BaseProgressSubscriber<List<Post>>(this) {
        override fun onNext(response: List<Post>) {
            super.onNext(response)
            view?.renderList(response)
        }
    }
}