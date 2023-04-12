package com.example.disher.categories.service

import com.example.disher.categories.model.CategoriesResponse
import retrofit2.http.GET

interface ICategoriesService {
    @GET(("categories.php"))
    suspend fun getAllCategories(): CategoriesResponse
}