package com.nambv.demo.newsappdemo.di

import com.nambv.demo.domain.repositories.DetailNewRepository
import com.nambv.demo.domain.repositories.NewsRepository
import com.nambv.demo.domain.usecases.GetDetailNewUseCase
import com.nambv.demo.domain.usecases.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsUseCase(repository: NewsRepository) = GetNewsUseCase(repository)

    @Singleton
    @Provides
    fun provideGetDetailNewUseCase(repository: DetailNewRepository) =
        GetDetailNewUseCase(repository)

}