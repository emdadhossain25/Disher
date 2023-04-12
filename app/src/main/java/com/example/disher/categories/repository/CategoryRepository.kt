package com.example.disher.categories.repository

import com.example.disher.categories.service.ICategoriesService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): String
}

class CategoryRepository @Inject constructor(
    val categoriesService: ICategoriesService
) : ICategoryRepository {
    override suspend fun getAllCategories(): String {
        return categoriesService.getAllCategories()
    }
}