package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn

abstract class ListUseCase<D>(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn
) : UseCase<List<D>>(subscribeOn, observeOn)
