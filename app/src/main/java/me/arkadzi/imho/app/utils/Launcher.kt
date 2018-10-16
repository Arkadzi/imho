package me.arkadzi.imho.app.utils

import android.app.Activity
import android.content.Intent
import me.arkadzi.imho.presentation.base.TabBarActivity
import me.arkadzi.imho.presentation.login.LoginActivity
import me.arkadzi.imho.presentation.profile.MainActivity

object Launcher {
    fun startLoginScreen(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    fun startMainScreen(activity: Activity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }

    fun startTabScreen(activity: Activity, mode: String, vararg params: Any) {
        activity.startActivity(Intent(activity, TabBarActivity::class.java).apply {
            putExtra(TabBarActivity.ARG_TAB_MODE, mode)
            putExtra(TabBarActivity.ARG_ADDITIONAL_ARGS, params)
        })
    }
}