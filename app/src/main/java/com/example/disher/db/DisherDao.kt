package com.example.disher.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.disher.details.model.MealDetails
import com.example.disher.details.model.SmallerMeal

@Dao
interface DisherDao {

    @Query("SELECT * FROM meal_details")
    suspend fun getAllMeals(): List<SmallerMeal>

    @Insert
    suspend fun saveMeal(meal: SmallerMeal)
}