package com.example.disher.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.disher.R
import com.example.disher.details.model.MealDetails
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
        is ViewState.Success -> {
            DetailsScreenSuccess(mealDetails = viewStateValue.meal)
        }
    }

}

@Composable
fun DetailsScreenSuccess(mealDetails: MealDetails) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(mealDetails.strMeal)
        Text(mealDetails.strArea)
        Image(
            modifier = Modifier
                .size(64.dp)
                .clickable {
// viewmodel save this item in db
                },
            painter = painterResource(R.drawable.heart),
            contentDescription = null
        )
        Image(
            modifier = Modifier.size(80.dp),
            painter = rememberImagePainter(mealDetails.strMealThumb),
            contentDescription = null
        )
        ClickableText(
            text = AnnotatedString(mealDetails.strYoutube), onClick = {
                uriHandler.openUri(uri = mealDetails.strYoutube)
            }
        )

        InstructionTexBlock(
            instruction = mealDetails.strInstructions
        )

    }
}

//extensionFunction for conditional inside
fun Modifier.`if`(
    condition: Boolean,
    then: Modifier.() -> Modifier
): Modifier =
    if (condition) {
        then()
    } else {
        this
    }

@Composable
fun InstructionTexBlock(modifier: Modifier = Modifier, instruction: String) {
    var showMore by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.`if`(!showMore) {
            height(100.dp)
        }) {
            Text(text = instruction)
        }

        Button(onClick = {
            showMore = !showMore
        }) {
            Text("Show More")
        }
    }
}