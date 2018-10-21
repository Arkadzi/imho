package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject


class CreateGraduateWorkUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : UseCase<Boolean>(subscribeOn, observeOn) {
    private lateinit var graduateWork: GraduateWork

    fun setData(graduateWork: GraduateWork) {
        this.graduateWork = graduateWork
    }

    override fun useCaseObservable() = repository.createGraduateWork(graduateWork)
}
