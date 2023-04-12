package com.example.disher.categories.service

import retrofit2.http.GET

interface ICategoriesService {
    @GET(("categories.php"))
    suspend fun getAllCategories(): String
}