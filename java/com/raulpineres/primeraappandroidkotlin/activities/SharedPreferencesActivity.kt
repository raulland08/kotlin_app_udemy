package com.raulpineres.primeraappandroidkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.app.preferences
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        buttonSave.setOnClickListener { setValuesSharedPreferences(); cleanEditTexts(); getValuesSharedPreferences();}
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        if (preferences.name.isNotEmpty() && preferences.age >= 0) {
            textViewSharedPrefs.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        } else {
            textViewSharedPrefs.text = "Welcome, please save your name and your age"
        }
    }

    private fun setValuesSharedPreferences() {
        if (editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()) {
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()

            Snackbar.make(buttonSave, "Values have been saved successfully!", Snackbar.LENGTH_LONG).show()

        } else {
            Snackbar.make(buttonSave, "Please fill name and age fields before saving", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun cleanEditTexts() {
        editTextName.text.clear()
        editTextAge.text.clear()
    }
}
