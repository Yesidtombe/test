package com.tombe.yesid.example.movies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tombe.yesid.example.movies.adapters.MovieAdapter
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.model.ResultMovies
import com.tombe.yesid.example.movies.net.ApiClient
import com.tombe.yesid.example.movies.util.Data
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<ResultMovies> {

    val adapter: MovieAdapter = MovieAdapter()
    val data:MutableList<Movie> = mutableListOf()
    var online: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        adapter.onMovieSelected = this::goToDetail

        val tipo = intent.extras?.getInt("item")
        title = getString(tipo!!)

        when(tipo){
            R.string.popular_movies -> ApiClient.movies.getPopularMovies()
                .enqueue(this)
            R.string.top_rated_movies -> ApiClient.movies.getTopRatedMovies()
                .enqueue(this)
            else -> ApiClient.movies.getUpcomingMovies().enqueue(this)
        }

    }

    //region loadData
    fun loadData(lista: List<Movie>){

        lista.forEach {
            data.add(Movie(it.popularity, it.vote_count, it.poster_path, it.id,
                it.original_language, it.original_title, it.genres, it.vote_average,
                it.overview, it.release_date, it.budget, it.homepage, it.runtime,
                it.production_companies))
        }
        online = true
        adapter.data = data

    }
    //endregion

    fun goToDetail(position: Int){

        if (online) startActivity<DetailActivity>("movie" to data[position],
            "online" to online)
        else startActivity<DetailActivity>("movie" to Data.data[position],
            "online" to online)

    }

    //region Callback retrofit
    override fun onResponse(call: Call<ResultMovies>, response: Response<ResultMovies>) {
        when(response.code()){
            200 -> {
                val res: ResultMovies = response.body()!!
                loadData(res.results)
            }
            401 -> toast("Invalid API key: You must be granted a valid key")
            else -> toast("¡ Movies not found !")
        }
    }

    override fun onFailure(call: Call<ResultMovies>, t: Throwable) {

        Toast.makeText(this,
            "Error retrieving information. Check your internet connection. The movie data shown are static",
            Toast.LENGTH_LONG).show()
        online = false
        adapter.data = Data.data

    }
    //endregion

}