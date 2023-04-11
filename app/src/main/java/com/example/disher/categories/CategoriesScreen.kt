package com.example.disher.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.categories.viewmodel.CategoriesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun CategoriesScreen(
    categoriesViewModel: CategoriesViewModel = hiltViewModel()
) {
    val categories = getFakeData()
    Column {
        Text(text = "INITIAL SETUP DONE")
        Spacer(modifier = Modifier.height(30.dp))
        categories.forEach {
            Text(text = it)
        }
    }
}


fun getFakeData(): List<String> {
    return listOf(
        "fish",
        "vegan",
        "meat"
    )
}