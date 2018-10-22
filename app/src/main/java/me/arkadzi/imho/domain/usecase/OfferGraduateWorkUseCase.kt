package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject
import kotlin.properties.Delegates


class OfferGraduateWorkUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : UseCase<Boolean>(subscribeOn, observeOn) {
    private var workId: Long by Delegates.notNull()
    private var userId: Long by Delegates.notNull()
    private var cancel: Boolean by Delegates.notNull()

    fun setData(workId: Long, userId: Long, cancel: Boolean) {
        this.workId = workId
        this.userId = userId
        this.cancel = cancel
    }

    override fun useCaseObservable() = repository.offerWork(workId, userId, cancel)
}
