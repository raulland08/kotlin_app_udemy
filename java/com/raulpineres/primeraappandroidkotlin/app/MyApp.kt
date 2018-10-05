package com.raulpineres.primeraappandroidkotlin.app

import android.app.Application
import com.raulpineres.primeraappandroidkotlin.others.MySharedPreferences

val preferences: MySharedPreferences by lazy { MyApp.pres!! }

class MyApp: Application() {

    companion object {
        var pres: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        pres = MySharedPreferences(applicationContext)
    }
}