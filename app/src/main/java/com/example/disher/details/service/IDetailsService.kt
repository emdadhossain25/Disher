package com.example.disher.details.service

import com.example.disher.details.model.DetailsResponse
import com.example.disher.details.repository.DetailsRepository
import retrofit2.http.GET
import retrofit2.http.Query

interface IDetailsService {

    @GET("lookup.php")
    suspend fun getDetails(@Query("i") id: String): DetailsResponse
}