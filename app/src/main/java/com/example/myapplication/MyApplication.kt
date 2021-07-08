package com.example.myapplication

import androidx.multidex.MultiDexApplication
import com.example.myapplication.di.DaggerAppComponent
import com.example.myapplication.di.module.AppModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object{
        var INSTANCE: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)

    }

    override fun androidInjector(): DispatchingAndroidInjector<Any> = dispatchingAndroidInjector

}