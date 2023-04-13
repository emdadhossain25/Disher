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
import androidx.compose.runtime.DisposableEffect
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
import com.example.disher.categories.viewmodel.ViewState

@Composable
fun CategoriesScreen(
    categoriesViewModel: CategoriesViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {


    val viewState by remember { categoriesViewModel.viewState }

    DisposableEffect(key1 = "category") {
        onDispose { }
    }
    when (viewState) {
        is ViewState.Error -> Text(text = (viewState as ViewState.Error).errorMessage)
        ViewState.Loading -> Text(text = "Loading")
        is ViewState.Success -> {
            LazyColumn {
                items((viewState as ViewState.Success).data) { item ->
                    SingleItemCategory(item) {
                        onItemClick(it)
                    }
                }
            }
        }
    }


}

@Composable
fun SingleItemCategory(
    item: Category,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(item.strCategory) }
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

