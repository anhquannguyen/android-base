package com.example.myapplication.di

import com.example.myapplication.MyApplication
import com.example.myapplication.di.module.AppModule
import com.example.myapplication.di.module.ScreenBuilder
import com.example.myapplication.di.module.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ScreenBuilder::class,
        ViewModelBuilder::class,
    ]
)
interface AppComponent {
    fun inject(app: MyApplication)

}