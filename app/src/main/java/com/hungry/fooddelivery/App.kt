package com.hungry.fooddelivery

import android.app.Application
import com.hungry.fooddelivery.data.local.database.AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.getInstance(this)
    }
}