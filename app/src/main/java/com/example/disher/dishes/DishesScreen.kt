package com.example.disher.dishes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.dishes.viewmodel.DishesViewModel

@Composable
fun DishesScreen(
    category: String,
    viewModel: DishesViewModel = hiltViewModel()
) {
    viewModel.getDishesForCategory(category)
    val listOfDishes by remember { viewModel.getDishesCategoryMealsList }

    LazyColumn {
        items(listOfDishes) { item ->
            Text(item.strMeal)

        }
    }
}
