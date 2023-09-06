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

}