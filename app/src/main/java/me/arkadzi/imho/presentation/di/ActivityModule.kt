package me.arkadzi.imho.presentation.di

import dagger.Module
import dagger.Provides
import me.arkadzi.imho.app.utils.Messages
import me.arkadzi.imho.domain.usecase.GetPostInfoUseCase
import me.arkadzi.imho.domain.usecase.GetPostsUseCase
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.presentation.presenters.PostDetailsPresenter
import me.arkadzi.imho.presentation.presenters.PostDetailsPresenterImpl
import me.arkadzi.imho.presentation.presenters.PostPresenter
import me.arkadzi.imho.presentation.presenters.PostPresenterImpl

@Module
class ActivityModule {

    @ActivityScope
    @Provides
    fun providePostPresenter(messages: Messages, getPostsUseCase: GetPostsUseCase): PostPresenter {
        return PostPresenterImpl(messages, getPostsUseCase)
    }

    @ActivityScope
    @Provides
    fun providePostDetailsPresenter(messages: Messages, getPostsUseCase: GetPostInfoUseCase): PostDetailsPresenter {
        return PostDetailsPresenterImpl(messages, getPostsUseCase)
    }

}

