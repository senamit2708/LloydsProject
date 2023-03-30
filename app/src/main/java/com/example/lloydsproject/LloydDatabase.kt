package com.example.lloydsproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lloydsproject.userModule.database.UserDao
import com.example.lloydsproject.userModule.model.UserData

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class LloydDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        private var INSTANCE: LloydDatabase? = null
        private const val DB_NAME = "user_database"

        fun getDatabse(context: Context): LloydDatabase {
            return INSTANCE ?: synchronized(this) {
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    LloydDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instace
                instace
            }
        }
    }
}