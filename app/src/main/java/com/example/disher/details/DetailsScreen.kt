package com.example.disher.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

@Composable
fun DetailsScreen(
    id: String
) {
    DisposableEffect(key1 = Unit) {
        if (!id.isNullOrBlank()) {

            //call viewModel

        }
        onDispose { }
    }
    Text("$id")
}