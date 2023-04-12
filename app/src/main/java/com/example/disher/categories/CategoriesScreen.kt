package com.example.disher.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.disher.categories.model.Category
import com.example.disher.categories.viewmodel.CategoriesViewModel

@Composable
fun CategoriesScreen(
    categoriesViewModel: CategoriesViewModel = hiltViewModel(),
    onItemClick: () -> Unit
) {
    //compose screen recompose redraws screen
    // to survive that and also update new item
    val listOfCategories by remember { categoriesViewModel.categoriesList }

    LazyColumn {
        items(listOfCategories) { item ->
            SingleItemCategory(item){
                onItemClick()
            }
        }
    }

}

@Composable
fun SingleItemCategory(
    item: Category,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
            .fillMaxWidth(),
        elevation = 8.dp
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically


        ) {

            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(item.strCategoryThumb),
                contentDescription = null
            )
            Text(text = item.strCategory, fontSize = 24.sp)

        }
    }

}

