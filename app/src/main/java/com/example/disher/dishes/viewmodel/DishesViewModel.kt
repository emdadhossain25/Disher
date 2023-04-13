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

@HiltViewModel
class DishesViewModel @Inject constructor(
    val usecase: IDishesUsecase
) : ViewModel() {
    private val _getDishesCategoryMealsList: MutableState<List<Meal>> = mutableStateOf(emptyList())
    val getDishesCategoryMealsList: State<List<Meal>> = _getDishesCategoryMealsList
    fun getDishesForCategory(catname: String) {
        viewModelScope.launch {
            val dishesResponse = usecase(catname)
            _getDishesCategoryMealsList.value = dishesResponse.meals

        }

    }
}