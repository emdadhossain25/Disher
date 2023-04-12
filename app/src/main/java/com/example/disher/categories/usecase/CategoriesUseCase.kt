package com.example.disher.categories.usecase

import com.example.disher.categories.repository.ICategoryRepository
import javax.inject.Inject


interface ICategoriesUseCase {
    operator suspend fun invoke(): String
}

class CategoriesUseCase @Inject constructor(
    val repository: ICategoryRepository
) : ICategoriesUseCase {
    override suspend fun invoke(): String {
        return repository.getAllCategories()
    }

}