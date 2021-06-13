package com.nambv.demo.data.di

import android.content.Context
import androidx.room.Room
import com.nambv.demo.data.api.NewsService
import com.nambv.demo.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Created by nambv on 6/12/2021
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DatabaseName

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @BaseUrlApi
    @Singleton
    @Provides
    fun provideBaseUrl(): String = "https://raw.githubusercontent.com/Akaizz/static/master/"

    @DatabaseName
    @Singleton
    @Provides
    fun provideDatabaseName(): String = "new_feed"

    @Provides
    @Singleton
    fun provideNewsService(@BaseUrlApi baseUrl: String): NewsService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        @DatabaseName databaseName: String
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        databaseName
    ).build()


    @Provides
    fun provideNewsDao(database: AppDatabase) = database.newsDao()

}