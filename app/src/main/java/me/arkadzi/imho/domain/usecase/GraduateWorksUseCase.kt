package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject
import kotlin.properties.Delegates


class GraduateWorksUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : ListUseCase<GraduateWork>(subscribeOn, observeOn) {
    var userId: Long by Delegates.notNull()
    var isOwner: Boolean by Delegates.notNull()

    fun setData(userId: Long, isOwner: Boolean) {
        this.userId = userId
        this.isOwner = isOwner
    }
    override fun useCaseObservable() = repository.getGraduateWorks(userId, isOwner)
}
