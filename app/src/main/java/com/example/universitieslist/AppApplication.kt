package com.example.universitieslist

import android.app.Application
import com.example.universitieslist.di.AppComponents
import com.example.universitieslist.di.DaggerAppComponents

class AppApplication: Application() {

    lateinit var appComponents: AppComponents
    override fun onCreate() {
        super.onCreate()
        appComponents= DaggerAppComponents.builder().build()
    }
}