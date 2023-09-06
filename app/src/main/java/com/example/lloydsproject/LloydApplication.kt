package com.example.lloydsproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LloydApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}