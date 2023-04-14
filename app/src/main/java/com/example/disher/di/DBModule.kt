package com.example.disher.di

import android.content.Context
import androidx.room.Room
import com.example.disher.db.DisherDao
import com.example.disher.db.DisherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun providesDB(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        DisherDatabase::class.java,
        "disher_database"
    ).build()

    @Provides
    @Singleton
    fun provideDisherDao(db: DisherDatabase): DisherDao {
        return db.provideDao()
    }
}