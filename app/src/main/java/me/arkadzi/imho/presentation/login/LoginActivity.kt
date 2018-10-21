package me.arkadzi.imho.presentation.login

import android.annotation.SuppressLint
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_login.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.Launcher
import me.arkadzi.imho.app.utils.textStr
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.base.BaseMvpActivity

class LoginActivity : BaseMvpActivity<LoginView, LoginPresenter>(), LoginView {
    override val contentViewId = R.layout.activity_login

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    @SuppressLint("CheckResult")
    override fun initViews() {
        RxView.clicks(btLogin)
                .subscribe {
                    presenter.onLogin(etLogin.textStr, etPassword.textStr)
                }
        etLogin.setText("ark@mail.me")
        etPassword.setText("asd")
    }

    override fun goToProfile(user: User) {
        Launcher.startProfileScreen(this, user)
        finish()
    }
}
