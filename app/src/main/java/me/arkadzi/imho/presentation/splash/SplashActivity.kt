package me.arkadzi.imho.presentation.splash

import android.os.Bundle
import me.arkadzi.imho.app.utils.Launcher
import me.arkadzi.imho.app.utils.applicationComponent
import me.arkadzi.imho.presentation.base.BaseActivity

class SplashActivity: BaseActivity() {
    override val contentViewId = null

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (applicationComponent.account().isAuthorized()) {
            Launcher.startMainScreen(this)
        } else {
            Launcher.startLoginScreen(this)
        }
        finish()
    }
}