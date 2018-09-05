package com.raulpineres.primeraappandroidkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_click_events.*

class ClickEventsActivity : ToolbarActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        clickInLine()

        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    //Para llamar click desde XML la función debe ser pública (por defecto) y debe recibir parámetro de tipo View
    fun xmlClick(view : View){
        Snackbar.make(view, "Click by XML",Snackbar.LENGTH_SHORT).show()
    }

    private fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonInline)
        btn.setOnClickListener{ Toast.makeText(this, "Click in line", Toast.LENGTH_SHORT).show() }
    }

    override fun onLongClick(v: View): Boolean {
        when(v.id){
            R.id.buttonClickMulti1 -> Snackbar.make(v, "Click Multiple 1", Snackbar.LENGTH_SHORT).show()
            R.id.buttonClickMulti2 -> Snackbar.make(v, "Click Multiple 2", Snackbar.LENGTH_SHORT).show()
            R.id.buttonClickMulti3 -> Snackbar.make(v, "Click Multiple 3", Snackbar.LENGTH_SHORT).show()
        }
        return true
    }

}
