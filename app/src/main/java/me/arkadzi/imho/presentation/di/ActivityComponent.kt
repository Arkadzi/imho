package me.arkadzi.imho.presentation.di

import dagger.Subcomponent
import me.arkadzi.imho.presentation.base.LabContentActivity
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.diploma.DiplomaActivity
import me.arkadzi.imho.presentation.lab_content.LabPrioritiesFragment
import me.arkadzi.imho.presentation.lab_content.LabPriorityActivity
import me.arkadzi.imho.presentation.labs.LaboratoriesFragment
import me.arkadzi.imho.presentation.labs.LabsActivity
import me.arkadzi.imho.presentation.labs.LecturersActivity
import me.arkadzi.imho.presentation.lecturers.LecturersFragment
import me.arkadzi.imho.presentation.login.LoginActivity
import me.arkadzi.imho.presentation.profile.ProfileActivity
import me.arkadzi.imho.presentation.profile.DiplomaListFragment
import me.arkadzi.imho.presentation.splash.SplashActivity


@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(splashActivity: SplashActivity)
    fun inject(profileActivity: ProfileActivity)
    fun inject(LAbContentActivity: LabContentActivity)
    fun inject(laboratoriesFragment: LaboratoriesFragment)
    fun inject(lecturersFragment: LecturersFragment)
    fun inject(labPrioritiesFragment: LabPrioritiesFragment)
    fun inject(diplomaListFragment: DiplomaListFragment)
    fun inject(labsActivity: LabsActivity)
    fun inject(lecturersActivity: LecturersActivity)
    fun inject(labPriorityActivity: LabPriorityActivity)
    fun inject(diplomaActivity: DiplomaActivity)
}
