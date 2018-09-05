package com.raulpineres.primeraappandroidkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.raulpineres.primeraappandroidkotlin.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener{ Toast.makeText(this, "Click FindViewById", Toast.LENGTH_SHORT).show() }

        //Por KAT se obtienen los recursos del layout que tengan un id asignado
        buttonByKAT.setOnClickListener { Toast.makeText(this, "Click by KAT", Toast.LENGTH_SHORT).show() }
    }
}
