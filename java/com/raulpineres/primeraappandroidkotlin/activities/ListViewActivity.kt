package com.raulpineres.primeraappandroidkotlin.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.raulpineres.primeraappandroidkotlin.R
import com.raulpineres.primeraappandroidkotlin.adapters.PersonAdapter
import com.raulpineres.primeraappandroidkotlin.models.Person
import com.raulpineres.primeraappandroidkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : ToolbarActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        personList = getPersonas()
        adapter = PersonAdapter(this, R.layout.recycler_view, personList)
        recyclerView.adapter = adapter
    }

    private fun getPersonas(): List<Person>{
        val listPeople = listOf(
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19),
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19),
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19),
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19),
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19),
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19),
                Person("Cosqui","Perez", 27),
                Person("Raul","Piñeres", 22),
                Person("Willy","Wonka", 28),
                Person("Cosquillita","Zapata", 25),
                Person("Victor","Chaza", 19)
        )

        return listPeople
    }
}
