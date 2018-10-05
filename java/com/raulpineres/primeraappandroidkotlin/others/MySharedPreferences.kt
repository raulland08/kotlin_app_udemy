package com.raulpineres.primeraappandroidkotlin.others

import android.content.Context

class MySharedPreferences(context: Context) {
    private val fileName = "mis_preferencias"
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    //Para cada variable se hace lo siguiente
    var name: String
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}