package com.example.myapplication.data.api

import com.example.myapplication.BuildConfig
import com.example.myapplication.extension.log
import com.google.gson.Gson
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//object ApiClient {

//    fun <T> createService(service: Class<T>): T = retrofit.create(service)
//
//    private val retrofit: Retrofit by lazy {
//        val gson = Gson().newBuilder().setLenient().create()
//        val factory = GsonConverterFactory.create(gson)
//
//        Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl(BuildConfig.BASE_URL)
//            .addConverterFactory(factory)
//            .build()
//    }
//
//    private val okHttpClient: OkHttpClient by lazy {
//        val httpLoggingInterceptor = HttpLoggingInterceptor { log(it) }
//        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
//
//        OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .addInterceptor(apiInterceptor)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .build()
//    }
//
//    private val apiInterceptor: Interceptor by lazy {
//        Interceptor { chain ->
//            val originalRequest = chain.request()
//            val headers = Headers.Builder()
//                .add("Authorization", token)
//                .add("Accept", "application/json")
//                .add("Content-Type", "application/json")
//                .build()
//            val newRequest = originalRequest.newBuilder().headers(headers)
//                .method(originalRequest.method, originalRequest.body)
//                .build()
//            chain.proceed(newRequest)
//        }
//    }


//}