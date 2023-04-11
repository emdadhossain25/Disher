package com.example.disher.categories.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.disher.categories.usecase.ICategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    useCase: ICategoriesUseCase
) : ViewModel() {
    init {
        val result = useCase()
        Log.d("CategoriesViewModel", result)
    }
}