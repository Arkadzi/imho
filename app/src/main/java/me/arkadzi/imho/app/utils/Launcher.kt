package me.arkadzi.imho.app.utils

import android.app.Activity
import android.content.Intent
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.base.LabContentActivity
import me.arkadzi.imho.presentation.chart.CalendarActivity
import me.arkadzi.imho.presentation.diploma.DiplomaActivity
import me.arkadzi.imho.presentation.lab_content.LabPriorityActivity
import me.arkadzi.imho.presentation.labs.LabsActivity
import me.arkadzi.imho.presentation.labs.LecturersActivity
import me.arkadzi.imho.presentation.login.LoginActivity
import me.arkadzi.imho.presentation.profile.ProfileActivity

object Launcher {
    fun startLoginScreen(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    fun startProfileScreen(activity: Activity, user: User) {
        activity.startActivity(Intent(activity, ProfileActivity::class.java).apply {
            putExtra(ProfileActivity.ARG_USER, user)
        })
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

    fun startLabPriorityActivity(activity: Activity, labPriority: LabPriority) {
        activity.startActivity(Intent(activity, LabPriorityActivity::class.java).apply {
            putExtra(LabPriorityActivity.ARG_LAB_PRIORITY, labPriority)
        })
    }

    fun startDiplomaWorkScreen(activity: Activity, graduateWork: GraduateWork? = null) {
        activity.startActivity(Intent(activity, DiplomaActivity::class.java).apply {
            putExtra(DiplomaActivity.ARG_DIPLOMA, graduateWork)
        })
    }

    fun startCalendarActivity(activity: Activity) {
        activity.startActivity(Intent(activity, CalendarActivity::class.java))
    }
}