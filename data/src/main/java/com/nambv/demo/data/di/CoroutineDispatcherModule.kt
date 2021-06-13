package com.nambv.demo.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Created by nambv on 5/8/2021
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherIO

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherMain

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherDefault

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @DispatcherIO
    @Singleton
    @Provides
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @DispatcherMain
    @Singleton
    @Provides
    fun provideDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

    @DispatcherDefault
    @Singleton
    @Provides
    fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

}