package com.example.disher.dishes.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.dishes.model.Meal
import com.example.disher.dishes.usecase.IDishesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<Meal>) : ViewState()
    data class Error(val errorMessage: String) : ViewState()
}

@HiltViewModel
class DishesViewModel @Inject constructor(
    val usecase: IDishesUsecase
) : ViewModel() {
    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val viewState: State<ViewState> = _viewState
    fun getDishesForCategory(catname: String) {
        viewModelScope.launch {
            try {
                val dishesResponse = usecase(catname)
                _viewState.value = ViewState.Success(dishesResponse.meals)
            } catch (e: Exception) {
                _viewState.value = ViewState.Error(e.message ?: "Unknown Error Message")
            }

        }

    }
}