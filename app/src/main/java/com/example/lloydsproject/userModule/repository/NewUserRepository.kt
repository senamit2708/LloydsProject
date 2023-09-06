package com.example.lloydsproject.userModule.repository


import android.util.Log
import com.example.lloydsproject.LloydDatabase
import com.example.lloydsproject.userModule.model.UserData
import javax.inject.Inject

class NewUserRepository @Inject constructor(database: LloydDatabase) {
    val userDao = database.getUserDao()
    private val TAG = NewUserRepository::class.java.simpleName

    suspend fun saveUserData(userData: UserData) {
       val count = userDao.insertUser(userData)
        Log.d(TAG, "user added status: $count")
    }
}