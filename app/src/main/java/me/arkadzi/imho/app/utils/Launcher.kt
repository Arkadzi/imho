package me.arkadzi.imho.app.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import me.arkadzi.imho.presentation.login.LoginActivity
import me.arkadzi.imho.presentation.login.MainActivity

object Launcher {
    fun startLoginScreen(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    fun startMainScreen(activity: Activity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }
}