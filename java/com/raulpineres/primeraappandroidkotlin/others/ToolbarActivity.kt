package com.raulpineres.primeraappandroidkotlin.others

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.raulpineres.primeraappandroidkotlin.models.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {

    protected var _toolbar : Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let { setSupportActionBar(_toolbar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}
