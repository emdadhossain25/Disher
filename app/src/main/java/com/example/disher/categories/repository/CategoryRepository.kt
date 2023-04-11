package com.example.disher.categories.repository

import javax.inject.Inject

interface ICategoryRepository {
    fun getAllCategories(): String
}

class CategoryRepository @Inject constructor(

) : ICategoryRepository {
    override fun getAllCategories(): String {
        return "PAGE 42"
    }
}