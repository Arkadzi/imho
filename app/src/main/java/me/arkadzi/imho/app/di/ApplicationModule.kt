package me.arkadzi.imho.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import me.arkadzi.imho.app.Application
import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.data.di.DataModule
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Singleton

@Module(includes = arrayOf(DataModule::class))
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplicationContext() : Context = application

    @Provides
    @Singleton
    internal fun provideSubscribeOn() = { Schedulers.newThread() }

    @Singleton
    @Provides
    internal fun provideObserveOn() = { AndroidSchedulers.mainThread() }

    @Singleton
    @Provides
    internal fun provideMessages(c: Context) = Messages(c)
}
