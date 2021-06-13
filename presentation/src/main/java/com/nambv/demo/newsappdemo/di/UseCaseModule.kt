package com.nambv.demo.newsappdemo.di

import com.nambv.demo.data.repositories.DetailNewRepositoryImpl
import com.nambv.demo.data.repositories.NewsRepositoryImpl
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
    fun provideGetNewsUseCase(repository: NewsRepositoryImpl) = GetNewsUseCase(repository)

    @Singleton
    @Provides
    fun provideGetDetailNewUseCase(repository: DetailNewRepositoryImpl) =
        GetDetailNewUseCase(repository)

}