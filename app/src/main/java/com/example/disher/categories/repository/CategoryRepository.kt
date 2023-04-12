package com.example.disher.categories.repository

import com.example.disher.categories.model.CategoriesResponse
import com.example.disher.categories.service.ICategoriesService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoriesResponse
}

class CategoryRepository @Inject constructor(
    val categoriesService: ICategoriesService
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoriesResponse {
        return categoriesService.getAllCategories()
    }
}