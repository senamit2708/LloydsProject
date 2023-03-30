package com.example.lloydsproject

import com.example.lloydsproject.userModule.model.ResponseUserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/users")
    suspend fun getAllUser(
        @Query("page") currentPage: Int,
        @Query("per_page") pageSize: Int
    ): Response<ResponseUserData>
}