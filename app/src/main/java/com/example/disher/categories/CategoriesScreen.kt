package com.example.disher.categories

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.categories.viewmodel.CategoriesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun CategoriesScreen(
    categoriesViewModel: CategoriesViewModel = hiltViewModel()
) {
    Text(text = "INITIAL SETUP DONE")

}