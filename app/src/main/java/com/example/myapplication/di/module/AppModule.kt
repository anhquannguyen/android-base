package com.example.myapplication.di.module

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.myapplication.BuildConfig
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.di.ApplicationContext
import com.example.myapplication.extension.log
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(private val application: MultiDexApplication) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, factory: GsonConverterFactory): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(factory)
            .build()

    @Singleton
    @Provides
    fun okHttpClient(
        httpLogging: HttpLoggingInterceptor,
        apiInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLogging)
            .addInterceptor(apiInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun factory(): GsonConverterFactory {
        val builder = Gson().newBuilder().setLenient().create()
        return GsonConverterFactory.create(builder)
    }

    @Singleton
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { log(it) }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun apiInterceptor(): Interceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val headers = Headers.Builder()
//                .add("Authorization", token)
//                .add("Accept", "application/json")
//                .add("Content-Type", "application/json")
            .build()
        val newRequest = originalRequest.newBuilder().headers(headers)
            .method(originalRequest.method, originalRequest.body)
            .build()
        chain.proceed(newRequest)
    }

    @Provides
    fun apiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}