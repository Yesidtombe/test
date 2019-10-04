package com.tombe.yesid.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tombe.yesid.example.movies.adapters.MovieAdapter
import com.tombe.yesid.example.movies.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapter: MovieAdapter = MovieAdapter()
    val data:MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        adapter.onMovieSelected = this::goToDetail
        loadData()
    }

    fun loadData(){
        data.add(
            Movie("/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
            "StarWars Episodio VIII", 150, "2018/10/5", ""))
        data.add(
            Movie("/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
                "Justice League", 120, "2016/7/16", ""))
        data.add(
            Movie("/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                null, 170, "2015/4/25", ""))
        adapter.data = data
    }

    fun goToDetail(position: Int){
        Toast.makeText(this, "Pelicula: ${data[position].name}", Toast.LENGTH_SHORT)
            .show()
    }

}