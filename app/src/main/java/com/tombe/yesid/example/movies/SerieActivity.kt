package com.tombe.yesid.example.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tombe.yesid.example.movies.adapters.SerieAdapter
import com.tombe.yesid.example.movies.model.Serie
import kotlinx.android.synthetic.main.activity_serie.*

class SerieActivity : AppCompatActivity() {

    val adapter: SerieAdapter = SerieAdapter()
    val data: MutableList<Serie> = mutableListOf()
    var online: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)
        list2.adapter = adapter
        //adapter.onSerieSelected =

        val tipo = intent.extras?.getInt("item")
        title = getString(tipo!!)

        when(tipo){
            
        }
    }
}
