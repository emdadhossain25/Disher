package com.example.disher.details.repository

import com.example.disher.details.model.DetailsResponse
import com.example.disher.details.service.IDetailsService
import javax.inject.Inject


interface IDetailsRepository {
    suspend fun getDetails(id: String): DetailsResponse
}


class DetailsRepository @Inject constructor(
    val service: IDetailsService
) : IDetailsRepository {
    override suspend fun getDetails(id: String): DetailsResponse {
        return service.getDetails(id)
    }
}