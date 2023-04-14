package com.example.disher.details.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.db.DisherDao
import com.example.disher.details.model.MealDetails
import com.example.disher.details.model.convertToSmaller
import com.example.disher.details.usecase.IDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class ViewState {
    object Loading : ViewState()
    data class Success(val meal: MealDetails) : ViewState()
    data class Error(val error: String) : ViewState()
}

@HiltViewModel
class DetailsViewModel @Inject constructor(
    val useCase: IDetailsUseCase,
    val dao: DisherDao
) : ViewModel() {
    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val viewState = _viewState

    fun getDetails(id: String) {
        viewModelScope.launch {
            try {
                val detailsResponse = useCase(id)
                val meal = detailsResponse.meals[0]
                _viewState.value = ViewState.Success(meal)
            } catch (e: Exception) {
                _viewState.value = ViewState.Error("{${e.message}}")
            }
        }
    }

    fun saveMealToDb(meal: MealDetails) {
        viewModelScope.launch {
            dao.saveMeal(meal.convertToSmaller())
        }
    }
}