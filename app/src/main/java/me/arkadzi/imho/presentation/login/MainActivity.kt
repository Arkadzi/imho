package me.arkadzi.imho.presentation.login

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.Launcher
import me.arkadzi.imho.presentation.base.BaseActivity

class MainActivity: BaseActivity() {
    override val contentViewId = R.layout.activity_main

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button.setOnClickListener {
            Launcher.startLabLectScreen(this)
        }
    }
}