package me.arkadzi.imho.data.di

import android.content.Context

import java.util.concurrent.TimeUnit

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import me.arkadzi.imho.data.Constants
import me.arkadzi.imho.data.RepositoryImpl
import me.arkadzi.imho.presentation.di.scope.ActivityScope
import me.arkadzi.imho.data.local.LocalStorage
import me.arkadzi.imho.data.local.RamStorage
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.data.rest.RetrofitApi
import me.arkadzi.imho.data.store.DataStore
import me.arkadzi.imho.data.store.DataStoreProxy
import me.arkadzi.imho.domain.Repository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideOkClient(context: Context): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideRestApi(retrofit: Retrofit): RestApi {
        return RestApi(retrofit.create(RetrofitApi::class.java))
    }



    @Provides
    @Singleton
    fun provideLocalStorage(): LocalStorage {
        return RamStorage()
    }

    @Provides
    @Singleton
    fun provideDataStore(restApi: RestApi, storage: LocalStorage): DataStore {
        return DataStoreProxy(restApi, storage)
    }

    @Provides
    @Singleton
    fun provideRepository(dataStore: DataStore): Repository {
        return RepositoryImpl(dataStore)
    }

}
