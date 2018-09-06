package com.raulpineres.primeraappandroidkotlin.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.others.ToolbarActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.button_to_picasso)

        buttonLoader.setOnClickListener { loadImages() }

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").fetch()
    }

    private fun loadImages() {

        Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .fit()
                .transform(CircleTransform())
                .into(imageViewTop)
        Picasso.get()
                .load("https://desarrollador-android.com/wp-content/uploads/2015/02/materialdesign_introduction.png")
                .fit()
                .transform(CircleTransform())
                .into(imageViewToBottom)
    }
}
