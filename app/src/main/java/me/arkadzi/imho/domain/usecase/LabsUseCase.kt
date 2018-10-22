package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject


class LabsUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : ListUseCase<Lab>(subscribeOn, observeOn) {
    private var lectureId: Long? = null

    fun setData(lectureId: Long?) {
        this.lectureId = lectureId
    }

    override fun useCaseObservable() = repository.getLabs(lectureId)
}
