package me.arkadzi.imho.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import me.arkadzi.imho.data.AccountImpl
import me.arkadzi.imho.data.Constants
import me.arkadzi.imho.data.RepositoryImpl
import me.arkadzi.imho.data.local.LocalStorage
import me.arkadzi.imho.data.local.RamStorage
import me.arkadzi.imho.data.rest.RestApi
import me.arkadzi.imho.data.rest.RetrofitApi
import me.arkadzi.imho.domain.Repository
import me.arkadzi.imho.domain.model.Account
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideOkClient(context: Context, account: Account): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor {
                    val token = account.getToken()
                    val request = if (token != null) {
                        it.request().newBuilder()
                                .addHeader("Authorization", token)
                                .build()
                    } else {
                        it.request()
                    }
                    return@addInterceptor it.proceed(request)
                }
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
    fun provideRepository(restApi: RestApi, account: Account): Repository {
        return RepositoryImpl(restApi, account)
    }

    @Provides
    @Singleton
    fun provideAccount(context: Context): Account {
        return AccountImpl(context)
    }
}
