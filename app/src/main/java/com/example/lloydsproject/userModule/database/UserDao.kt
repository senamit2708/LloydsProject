package com.example.lloydsproject.userModule.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lloydsproject.userModule.model.UserData

@Dao
public abstract interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<UserData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userData: List<UserData>): LongArray

    @Delete
    suspend fun deleteUser(userData: UserData)

    @Query("DELETE FROM user")
    suspend fun clearAllUser()

}