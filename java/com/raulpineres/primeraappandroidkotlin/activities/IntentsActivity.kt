package com.raulpineres.primeraappandroidkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        button_intent_extras.setOnClickListener { goIntentExtras() }
        button_intent_flags.setOnClickListener { goIntentFlags() }
        button_intent_object.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "Raúl")
        intent.putExtra("last_name", "Piñeres")
        intent.putExtra("age", 25)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY //No guarda el activity en el stack(Pila)
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //Vacía el stack completo
        startActivity(intent)
        //finish() ---tampoco guarda el activity en el stack...lo destruye
    }

    private fun goIntentObject(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Raul","Piñeres",25,true)
        intent.putExtra("student",student)
        startActivity(intent)
    }
}
