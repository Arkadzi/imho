package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject
import kotlin.properties.Delegates


class LabPrioritiesUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : ListUseCase<LabPriority>(subscribeOn, observeOn) {
    private var labId: Long by Delegates.notNull()

    fun setData(labId: Long) {
        this.labId = labId
    }

    override fun useCaseObservable() = repository.getLabPriorities(labId)
}
