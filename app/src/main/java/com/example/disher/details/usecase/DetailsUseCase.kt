package com.example.disher.details.usecase

import com.example.disher.details.model.DetailsResponse
import com.example.disher.details.repository.IDetailsRepository
import javax.inject.Inject

interface IDetailsUseCase {
    suspend operator fun invoke(id: String): DetailsResponse
}

class DetailsUseCase @Inject constructor(
    val repository: IDetailsRepository
) : IDetailsUseCase {
    override suspend fun invoke(id: String): DetailsResponse {
        return repository.getDetails(id)
    }
}