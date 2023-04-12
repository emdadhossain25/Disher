package com.example.disher.categories.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.categories.model.Category
import com.example.disher.categories.usecase.ICategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    useCase: ICategoriesUseCase
) : ViewModel() {
    //    state is a wrapper around data which emits changes to its listeners

    //private one is mutable and receives changes from usecase
    private val _categoriesList: MutableState<List<Category>> = mutableStateOf(emptyList())

    // public one is immutable which is exposed to view (compose)
    val categoriesList: State<List<Category>> = _categoriesList

    init {
        viewModelScope.launch {
            val categoriesResponse = useCase()
            _categoriesList.value = categoriesResponse.categories

        }
    }
}