package me.arkadzi.imho.presentation.login

import me.arkadzi.imho.R
import me.arkadzi.imho.presentation.base.BaseActivity

class MainActivity: BaseActivity() {
    override val contentViewId = R.layout.activity_main

    override fun injectSelf() {
        activityComponent.inject(this)
    }
}