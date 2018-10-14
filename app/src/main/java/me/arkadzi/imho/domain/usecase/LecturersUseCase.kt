package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject


class LecturersUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : ListUseCase<Lecturer>(subscribeOn, observeOn) {

    override fun useCaseObservable() = repository.getLecturers()
}
