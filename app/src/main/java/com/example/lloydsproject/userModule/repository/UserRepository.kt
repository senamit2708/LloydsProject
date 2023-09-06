package com.example.lloydsproject.userModule.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.lloydsproject.LloydDatabase
import com.example.lloydsproject.RetrofitHelper
import com.example.lloydsproject.userModule.database.UserDao
import com.example.lloydsproject.userModule.model.UserData
import java.lang.Exception

class UserRepository(application: Application) {

    private val TAG = UserRepository::class.java.simpleName
    lateinit var userDatabase: LloydDatabase
    val userDao: UserDao

    init {
//        userDatabase =  //LloydDatabase.getDatabse(application);
        userDao = userDatabase.getUserDao()
    }

    fun getAllUser(): LiveData<List<UserData>> = userDao.getAllUser()

    suspend fun insertUser(userData: List<UserData>) {
        userDao.insert(userData)
    }

    suspend fun deleteUser(userData: UserData) {
        userDao.deleteUser(userData)
    }

    suspend fun clearAllUser() {
        userDao.clearAllUser()
    }

    suspend fun loadUserDataFromServer() {
        try {
            val result = RetrofitHelper.getService().getAllUser(1, 12)
            val data = result.body()?.data
            data?.let { userData ->
                userDao.insert(userData)
            }
        } catch (Ex: Exception) {
            Log.i(TAG, "error occured " + Ex.localizedMessage)
        }
    }
}