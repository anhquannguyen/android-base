package com.example.myapplication.di.module

import com.example.myapplication.ui.detail.DetailFragment
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScreenBuilder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun detailFragment(): DetailFragment
}