package me.arkadzi.imho.app.di

import javax.inject.Singleton

import dagger.Component
import me.arkadzi.imho.presentation.di.ActivityComponent
import me.arkadzi.imho.presentation.di.ActivityModule


@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    operator fun plus(activityModule: ActivityModule): ActivityComponent

}
