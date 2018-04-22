package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject


class GetPostsUseCase
@Inject
constructor(subscribeOn: SubscribeOn, observeOn: ObserveOn, private val repository: Repository) : UseCase<List<Post>>(subscribeOn, observeOn) {

    override fun useCaseObservable() = repository.getPosts()
}
