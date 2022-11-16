package com.example.forageapp

import android.app.Application
import com.example.forageapp.data.ForageDatabase

class BaseApplication: Application() {
    val database :ForageDatabase by lazy {
        ForageDatabase.getDatabase(this)
    }
}