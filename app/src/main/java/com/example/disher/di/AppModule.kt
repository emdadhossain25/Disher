package com.example.disher.di

import com.example.disher.categories.repository.CategoryRepository
import com.example.disher.categories.repository.ICategoryRepository
import com.example.disher.categories.service.ICategoriesService
import com.example.disher.categories.usecase.CategoriesUseCase
import com.example.disher.categories.usecase.ICategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    //use provide for other library
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): ICategoriesService {
        return retrofit.create(ICategoriesService::class.java)
    }

    //use interface for instance creation
    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        //        func(whatwillBeProvided):whenAskedForThis
        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideCategoryUseCase(categoryUseCase: CategoriesUseCase): ICategoriesUseCase


    }
}