package com.example.disher.di

import com.example.disher.categories.repository.CategoryRepository
import com.example.disher.categories.repository.ICategoryRepository
import com.example.disher.categories.usecase.CategoriesUseCase
import com.example.disher.categories.usecase.ICategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    //use interface for instance creation
    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        //        func(whatwillBeProvided):whenAskedForThis
        @Binds
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        fun provideCategoryUseCase(categoryUseCase: CategoriesUseCase): ICategoriesUseCase


    }
}