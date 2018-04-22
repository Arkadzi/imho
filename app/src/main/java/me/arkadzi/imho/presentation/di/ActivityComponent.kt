package me.arkadzi.imho.presentation.di

import dagger.Subcomponent
import me.arkadzi.imho.presentation.activities.PostsActivity
import me.arkadzi.imho.presentation.di.scope.ActivityScope


@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(postsActivity: PostsActivity)

}
