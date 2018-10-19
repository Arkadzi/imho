package me.arkadzi.imho.app.utils

import android.app.Activity
import android.content.Intent
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.base.LabContentActivity
import me.arkadzi.imho.presentation.labs.LabsActivity
import me.arkadzi.imho.presentation.labs.LecturersActivity
import me.arkadzi.imho.presentation.login.LoginActivity
import me.arkadzi.imho.presentation.profile.MainActivity

object Launcher {
    fun startLoginScreen(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    fun startMainScreen(activity: Activity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }

    fun startLabContentScreen(activity: Activity, lab: Lab) {
        activity.startActivity(Intent(activity, LabContentActivity::class.java).apply {
            putExtra(LabContentActivity.ARG_ADDITIONAL_ARGS, lab)
        })
    }

    fun startLabsActivity(activity: Activity) {
        activity.startActivity(Intent(activity, LabsActivity::class.java))
    }

    fun startLecturersActivity(activity: Activity) {
        activity.startActivity(Intent(activity, LecturersActivity::class.java))
    }
}