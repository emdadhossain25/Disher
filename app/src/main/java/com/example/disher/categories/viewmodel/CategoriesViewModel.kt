package com.example.disher.categories.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.categories.usecase.ICategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    useCase: ICategoriesUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            val result = useCase()
            Log.d("CategoriesViewModel", result)
        }
    }
}