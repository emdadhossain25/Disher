package com.example.disher.dishes.usecase

import com.example.disher.dishes.model.DishesResponse
import com.example.disher.dishes.repository.DishesRepository
import javax.inject.Inject

interface IDishesUsecase {
    suspend operator fun invoke(category: String): DishesResponse
}

class DishesUsecase @Inject constructor(
    val dishesRepository: DishesRepository
) : IDishesUsecase {
    override suspend fun invoke(category: String): DishesResponse {
        return dishesRepository.getDishes(category)
    }

}