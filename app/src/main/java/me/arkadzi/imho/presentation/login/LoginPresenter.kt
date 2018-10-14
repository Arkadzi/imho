package me.arkadzi.imho.presentation.login

import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.model.PostInfo
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.domain.subscribers.BaseProgressSubscriber
import me.arkadzi.imho.domain.usecase.LoginUseCase
import me.arkadzi.imho.presentation.base.ProgressPresenter
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class LoginPresenter @Inject constructor(
        messages: Messages,
        val loginUseCase: LoginUseCase
) : ProgressPresenter<LoginView>(messages) {


    fun onLogin(email:String, password: String) {
        loginUseCase.setData(email, password)
        loginUseCase.execute(getSubscriber())
    }

    private fun getSubscriber(): BaseProgressSubscriber<User> {
        return object: BaseProgressSubscriber<User>(this) {
            override fun onSuccess(value: User) {
                super.onSuccess(value)
                view?.goToProfile()
            }
        }
    }

    override fun onRelease() {
        loginUseCase.stopExecution()
        super.onRelease()
    }
}