package me.arkadzi.imho.presentation.presenters

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.PostInfo
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.domain.usecase.GetPostInfoUseCase
import me.arkadzi.imho.presentation.views.PostDetailsView

class PostDetailsPresenterImpl(messages: Messages, private val useCase: GetPostInfoUseCase) :
        ProgressPresenter<PostDetailsView>(messages),
        PostDetailsPresenter {

    override fun onCreate(view: PostDetailsView) {
        super.onCreate(view)
        if (!useCase.isWorking) {
            useCase.post = view.getPost()
        }
        useCase.execute(getPostsSubscriber())
    }

    override fun onRelease() {
        useCase.unsubscribe()
        super.onRelease()
    }

    override fun onRefresh(post: Post) {
        useCase.stopExecution()
        useCase.post = post
        useCase.execute(getPostsSubscriber())
    }

    private fun getPostsSubscriber() = object : BaseProgressSubscriber<PostInfo>(this) {
        override fun onNext(response: PostInfo) {
            super.onNext(response)
            view?.renderInfo(response)
        }
    }
}