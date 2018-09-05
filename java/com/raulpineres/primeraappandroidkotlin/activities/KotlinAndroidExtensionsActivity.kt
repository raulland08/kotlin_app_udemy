package com.raulpineres.primeraappandroidkotlin.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.Toast
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        toolbarToLoad(toolbar as Toolbar)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener{ Toast.makeText(this, "Click FindViewById", Toast.LENGTH_SHORT).show() }

        //Por KAT se obtienen los recursos del layout que tengan un id asignado
        buttonByKAT.setOnClickListener { Toast.makeText(this, "Click by KAT", Toast.LENGTH_SHORT).show() }
    }
}
