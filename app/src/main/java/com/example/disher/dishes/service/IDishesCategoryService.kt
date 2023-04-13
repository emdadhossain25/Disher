package com.example.disher.dishes.service

import com.example.disher.dishes.model.DishesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDishesCategoryService {
    @GET("filter.php")
    suspend fun getCategoryDishes(
        @Query("c") category: String
    ): DishesResponse
}