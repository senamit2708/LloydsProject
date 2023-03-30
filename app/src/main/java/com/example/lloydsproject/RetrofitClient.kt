package com.example.lloydsproject

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val baseUrl = "https://reqres.in"
    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    var mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttpLoggingInterceptor)
        .build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
    }

    fun getService(): ApiInterface {
        return getInstance().create(ApiInterface::class.java)
    }
}