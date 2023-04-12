package com.example.disher.dishes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DishesScreen(category: String?) {
    Text("Category of type $category")
}