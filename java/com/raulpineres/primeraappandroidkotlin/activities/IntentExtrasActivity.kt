package com.raulpineres.primeraappandroidkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.models.Student
import com.raulpineres.primeraappandroidkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        button_back.setOnClickListener { startActivity(Intent(this, IntentsActivity::class.java)) }

        if(!getIntentExtras() && !getObjectExtras()){
            check_box_developer.visibility = View.INVISIBLE
        }
    }

    private fun getIntentExtras() : Boolean{
        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("last_name")
        val age = intent.getIntExtra("age", 0)
        val developer = intent.getBooleanExtra("developer", false)

        if (name != null && lastName != null && age > 0){
            text_view_name.text = name
            text_view_last_name.text = lastName
            text_view_age.text = age.toString()
            check_box_developer.isChecked = developer
            check_box_developer.text = "Developer"
            return true
        }else return false
    }

    private fun getObjectExtras() : Boolean{
        val student = intent.getParcelableExtra<Student>("student")

        //se comprueba si el valor es null o no
        student?.let {
            text_view_name.text = student.name
            text_view_last_name.text = student.lastName
            text_view_age.text = student.age.toString()
            check_box_developer.isChecked = student.isDeveloper
            check_box_developer.text = "Developer"
            return true
        }
        return false
    }
}
