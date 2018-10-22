package me.arkadzi.imho.app

import android.content.Context

import me.arkadzi.imho.app.di.ApplicationComponent
import me.arkadzi.imho.app.di.ApplicationModule
import me.arkadzi.imho.app.di.DaggerApplicationComponent
import me.arkadzi.imho.presentation.di.ActivityComponent
import me.arkadzi.imho.presentation.di.ActivityModule

class Application : android.app.Application() {

    lateinit var appComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        buildAppComponent()
    }

    private fun buildAppComponent() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun logout() {
        appComponent.account().clear()
    }

    companion object {

        fun getApp(context: Context): Application {
            return context.applicationContext as Application
        }
    }

}
