package me.arkadzi.imho.domain.usecase

import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Inject


class LoginUseCase @Inject constructor(
        subscribeOn: SubscribeOn,
        observeOn: ObserveOn,
        private val repository: Repository
) : UseCase<User>(subscribeOn, observeOn) {
    lateinit var email: String
    lateinit var password: String

    override fun useCaseObservable() = repository.login(email, password)

    fun setData(email: String, password: String) {
        this.email = email
        this.password = password
    }
}
