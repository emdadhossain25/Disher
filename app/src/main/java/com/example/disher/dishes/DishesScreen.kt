package com.example.disher.dishes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.ImagePainter
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.disher.dishes.model.Meal
import com.example.disher.dishes.viewmodel.DishesViewModel
import com.example.disher.dishes.viewmodel.ViewState

@Composable
fun DishesScreen(
    category: String?,
    viewModel: DishesViewModel = hiltViewModel()
) {
    DisposableEffect(key1 = Unit) {
        if (!category.isNullOrBlank()) {
            viewModel.getDishesForCategory(category)
        }
        onDispose { }
    }
    val viewState by remember { viewModel.viewState }

    when (val viewStateValue = viewState) {
        is ViewState.Error -> Text(text = viewStateValue.errorMessage)
        ViewState.Loading -> Text(text = "Loading")
        is ViewState.Success -> LazyColumn {
            items(viewStateValue.data) { item ->
                SingleItemDishes(item)

            }
        }
    }

}

@Composable
fun SingleItemDishes(
    item: Meal
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(item.strMealThumb),
                contentDescription = null
            )
            Text(text = item.strMeal, fontSize = 24.sp)
        }

    }
}
