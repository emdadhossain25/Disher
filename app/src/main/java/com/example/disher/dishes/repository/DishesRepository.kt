package com.example.disher.dishes.repository

import com.example.disher.categories.service.ICategoriesService
import com.example.disher.dishes.model.DishesResponse
import com.example.disher.dishes.service.IDishesCategoryService
import javax.inject.Inject

interface IDishesRepository {
    suspend fun getDishes(catgory: String): DishesResponse
}

class DishesRepository @Inject constructor(
    val service: IDishesCategoryService
) : IDishesRepository {
    override suspend fun getDishes(catgory: String): DishesResponse {
        return service.getCategoryDishes(category = catgory)
    }

}