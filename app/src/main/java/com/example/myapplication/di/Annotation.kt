package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.reflect.KClass


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Preferences

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseInfo

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)