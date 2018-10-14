package me.arkadzi.imho.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.arkadzi.imho.app.Application
import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.data.di.DataModule
import me.arkadzi.imho.domain.schedulers.ObserveOn
import me.arkadzi.imho.domain.schedulers.SubscribeOn
import javax.inject.Singleton

@Module(includes = arrayOf(DataModule::class))
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context = application

    @Singleton
    @Provides
    internal fun provideSubscribeOn(): SubscribeOn = object : SubscribeOn {
        override fun scheduler() = Schedulers.newThread()
    }

    @Singleton
    @Provides
    internal fun provideObserveOn(): ObserveOn = object : ObserveOn {
        override fun scheduler() = AndroidSchedulers.mainThread()
    }

    @Singleton
    @Provides
    internal fun provideMessages(c: Context) = Messages(c)
}
