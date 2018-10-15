package me.arkadzi.imho.presentation.di

import dagger.Subcomponent
import me.arkadzi.imho.presentation.base.TabBarActivity
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.lab_content.LabPriorityFragment
import me.arkadzi.imho.presentation.labs.LaboratoriesFragment
import me.arkadzi.imho.presentation.lecturers.LecturersFragment
import me.arkadzi.imho.presentation.login.LoginActivity
import me.arkadzi.imho.presentation.login.MainActivity
import me.arkadzi.imho.presentation.splash.SplashActivity


@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(splashActivity: SplashActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(tabBarActivity: TabBarActivity)
    fun inject(laboratoriesFragment: LaboratoriesFragment)
    fun inject(lecturersFragment: LecturersFragment)
    fun inject(labPriorityFragment: LabPriorityFragment)
}
