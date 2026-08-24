package com.abdullojon.lugatapp.app

import android.app.Application
import com.abdullojon.lugatapp.data.MyDatabase

class Myapp: Application() {
    override fun onCreate() {
        super.onCreate()
        MyDatabase.Companion.init(this)
    }
}