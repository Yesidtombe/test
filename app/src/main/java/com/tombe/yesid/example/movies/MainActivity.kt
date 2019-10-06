package com.tombe.yesid.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tombe.yesid.example.movies.adapters.MovieAdapter
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.model.Pelicula
import com.tombe.yesid.example.movies.model.Result
import com.tombe.yesid.example.movies.net.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<Result> {

    val adapter: MovieAdapter = MovieAdapter()
    val data:MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        adapter.onMovieSelected = this::goToDetail

        ApiClient.movies.getPopularMovieAll()
            .enqueue(this)

        //loadData()
    }

    //region loadData
    fun loadData(lista: List<Pelicula>){

        Log.i("Size",""+lista.size)

        lista.forEach {
            Log.i("Pelicula", ""+it.original_title)
            data.add(Movie(it.poster_path!!,it.original_title,120,
                it.release_date,it.overview,""+it.popularity,
                ""+it.vote_count,""+it.vote_average,
                it.original_language,"2500000","Drama, Thriller, Action",
                "www.joker.com.co","20 Century Fox, Entertaiment"))
        }

//        data.add(
//            Movie("/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
//            "StarWars Episodio VIII", 150, "2018/10/5", "",
//                "0.5", "654", "8.5", "en",
//                "2500000", "Drama, Action, Comedy", "www.joker.com.co", "20 Century Fox, TNT"))
//        data.add(
//            Movie("/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
//                "Justice League", 120, "2016/7/16", "", null,
//                null, null, null, null, null, null, null))
//        data.add(
//            Movie("/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
//                null, 170, "2015/4/25", "", null,
//                null, null, null, null, null, null, null))
        adapter.data = data
    }
    //endregion

    fun goToDetail(position: Int){
        toast("Pelicula: ${data[position].name}")
        startActivity<DetailActivity>("movie" to data[position])
        //startActivity<DetailActivity>("movie" to position)
    }

    override fun onResponse(call: Call<Result>, response: Response<Result>) {
        when(response.code()){
            200 -> {
                val resultado:Result = response.body()!!
                Log.i("Resultado", "" + resultado.total_results)
                loadData(resultado.results)
//                Toast.makeText(this, "Resultado: " + resultado?.total_pages,
//                    Toast.LENGTH_SHORT).show()
            }
            401 -> {
                Log.i("Resultado", "Invalid API key")
                Toast.makeText(this, "Invalid API key: You must be granted a valid key",
                    Toast.LENGTH_SHORT).show()
            }
            else -> {
                Log.i("Resultado", "Movies not found")
                Toast.makeText(this, "¡ Movies not found !",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onFailure(call: Call<Result>, t: Throwable) {
        Toast.makeText(this, "Error al recuperar la informacion",
            Toast.LENGTH_SHORT).show()
    }

}