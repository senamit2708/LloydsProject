package com.example.lloydsproject.userModule.hilt

import android.content.Context
import androidx.room.Room
import com.example.lloydsproject.LloydDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private val DB_NAME = "database"

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun getDatabase(@ApplicationContext context: Context): LloydDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            LloydDatabase::class.java,
            DB_NAME
        ).build()
    }

}