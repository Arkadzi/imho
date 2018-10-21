package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.LabAndPriority
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject
import kotlin.properties.Delegates


class GetLabAndPriorityUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : UseCase<LabAndPriority>(subscribeOn, observeOn) {
    private var priorityId by Delegates.notNull<Long>()

    fun setData(priorityId: Long) {
        this.priorityId = priorityId
    }

    override fun useCaseObservable() = repository.getLabAndPriorities(priorityId)
}
