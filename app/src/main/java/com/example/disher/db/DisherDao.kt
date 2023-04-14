package com.example.disher.db

import androidx.room.Dao
import androidx.room.Query
import com.example.disher.details.model.MealDetails

@Dao
interface DisherDao {

    @Query("SELECT * FROM meal_details")
    suspend fun getAllMeals():List<MealDetails>
}