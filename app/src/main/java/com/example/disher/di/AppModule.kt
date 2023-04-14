package com.example.disher.di

import com.example.disher.categories.repository.CategoryRepository
import com.example.disher.categories.repository.ICategoryRepository
import com.example.disher.categories.service.ICategoriesService
import com.example.disher.categories.usecase.CategoriesUseCase
import com.example.disher.categories.usecase.ICategoriesUseCase
import com.example.disher.details.repository.DetailsRepository
import com.example.disher.details.repository.IDetailsRepository
import com.example.disher.details.service.IDetailsService
import com.example.disher.details.usecase.DetailsUseCase
import com.example.disher.details.usecase.IDetailsUseCase
import com.example.disher.dishes.repository.DishesRepository
import com.example.disher.dishes.repository.IDishesRepository
import com.example.disher.dishes.service.IDishesCategoryService
import com.example.disher.dishes.usecase.DishesUsecase
import com.example.disher.dishes.usecase.IDishesUsecase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): ICategoriesService {
        return retrofit.create(ICategoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideDishesCategoryService(retrofit: Retrofit): IDishesCategoryService {
        return retrofit.create(IDishesCategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideDetailsService(retrofit: Retrofit): IDetailsService {
        return retrofit.create(IDetailsService::class.java)
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

        @Binds
        @Singleton
        fun provideDishesUseCase(dishesUsecase: DishesUsecase): IDishesUsecase

        @Binds
        @Singleton
        fun provideDishesRepository(dishesRepository: DishesRepository): IDishesRepository

        @Binds
        @Singleton
        fun provideDetailsUseCase(detailsUseCase: DetailsUseCase): IDetailsUseCase

        @Binds
        @Singleton
        fun provideDetailsRepository(detailsRepository: DetailsRepository): IDetailsRepository
    }
}