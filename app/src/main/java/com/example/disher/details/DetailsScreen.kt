package com.example.disher.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.details.viewmodel.DetailsViewModel
import com.example.disher.details.viewmodel.ViewState


@Composable
fun DetailsScreen(
    id: String,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val viewState by remember { viewModel.viewState }
    DisposableEffect(key1 = Unit) {
        if (!id.isNullOrBlank()) {

            viewModel.getDetails(id)

        }
        onDispose { }
    }
    when (val viewStateValue = viewState) {
        is ViewState.Error -> Text(viewStateValue.error)
        ViewState.Loading -> Text("Loading")
        is ViewState.Success -> Text("${viewStateValue.detailsResponse}")
    }

}