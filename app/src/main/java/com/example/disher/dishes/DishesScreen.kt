package com.example.disher.dishes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.dishes.viewmodel.DishesViewModel
import com.example.disher.dishes.viewmodel.ViewState

@Composable
fun DishesScreen(
    category: String?,
    viewModel: DishesViewModel = hiltViewModel()
) {
    DisposableEffect(key1 = "dishes") {
        if (!category.isNullOrBlank()) {
            viewModel.getDishesForCategory(category)
        }
        onDispose { }
    }
    val viewState by remember { viewModel.viewState }

    when (viewState) {
        is ViewState.Error -> Text(text = (viewState as ViewState.Error).errorMessage)
        ViewState.Loading -> Text(text = "Loading")
        is ViewState.Success -> Text(text = "" + (viewState as ViewState.Success).data)
    }

}
