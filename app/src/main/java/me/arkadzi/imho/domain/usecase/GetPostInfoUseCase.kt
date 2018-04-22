package me.arkadzi.imho.domain.usecase

import javax.inject.Inject

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.PostInfo
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn


class GetPostInfoUseCase
@Inject
constructor(subscribeOn: SubscribeOn, observeOn: ObserveOn, private val repository: Repository) : UseCase<PostInfo>(subscribeOn, observeOn) {
    lateinit var post: Post

    override fun useCaseObservable() = repository.getPostInfo(post)
}
