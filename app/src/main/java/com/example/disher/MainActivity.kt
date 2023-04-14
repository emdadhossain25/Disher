package com.example.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.disher.categories.CategoriesScreen
import com.example.disher.details.DetailsScreen
import com.example.disher.dishes.DishesScreen
import com.example.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}

@Composable
fun DisherApp() {
    /**
     * details composable - Details Screen
     */

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "category"
    ) {
        composable("category") {
            CategoriesScreen() { category ->
                navController.navigate("dishes/$category")
            }

        }
        composable(
            "dishes/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            val categoryStr = remember {
                it.arguments?.getString("category")
            }
            DishesScreen(categoryStr ?: "") { id ->
                navController.navigate("meal/$id")
            }
        }
        composable(
            "meal/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) {
            val mealId = remember { it.arguments?.getString("id") }
            DetailsScreen(id = mealId ?: "")
        }

    }
}