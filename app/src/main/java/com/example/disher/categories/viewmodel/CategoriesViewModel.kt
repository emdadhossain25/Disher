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


sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<Category>) : ViewState()
    data class Error(val errorMessage: String) : ViewState()
}

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    useCase: ICategoriesUseCase
) : ViewModel() {

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)

    val viewState: State<ViewState> = _viewState

    init {
        viewModelScope.launch {
            try {
                val categoriesResponse = useCase()
                _viewState.value = ViewState.Success(categoriesResponse.categories)
            } catch (e: Exception) {
                _viewState.value = ViewState.Error(e.message ?: "Unknown Error")
            }


        }
    }
}