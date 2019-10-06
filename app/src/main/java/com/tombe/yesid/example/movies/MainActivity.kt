package com.tombe.yesid.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tombe.yesid.example.movies.adapters.MovieAdapter
import com.tombe.yesid.example.movies.model.Movie
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
    var online: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        adapter.onMovieSelected = this::goToDetail

        ApiClient.movies.getPopularMovieAll()
            .enqueue(this)
    }

    //region loadData
    fun loadData(lista: List<Movie>){

        Log.i("Pelicula On", ""+lista[0])
        lista.forEach {
            data.add(Movie(it.popularity, it.vote_count, it.poster_path,
                it.id, it.original_language, it.original_title, it.vote_average, it.overview, it.release_date,
                it.budget, it.homepage, it.runtime))
        }
        online = true
        adapter.data = data

    }
    //endregion

    fun goToDetail(position: Int){
        //toast("Pelicula: ${data[position].original_title}")
        startActivity<DetailActivity>("movie" to data[position],
            "online" to online)
    }

    override fun onResponse(call: Call<Result>, response: Response<Result>) {
        when(response.code()){
            200 -> {
                val res: Result = response.body()!!
                loadData(res.results)
            }
            401 -> toast("Invalid API key: You must be granted a valid key")
            else -> toast("¡ Movies not found !")
        }
    }

    override fun onFailure(call: Call<Result>, t: Throwable) {

        Toast.makeText(this,
            "Error retrieving information. Check your internet connection. The movie data shown are static",
            Toast.LENGTH_LONG).show()

        data.add(Movie(172.1,603, "/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
            429203, "en", "The Old Man & the Gun",6.3,
            "The true story of Forrest Tucker, from his audacious escape from San Quentin at the age of 70 to an unprecedented string of heists that confounded authorities and enchanted the public. Wrapped up in the pursuit are a detective, who becomes captivated with Forrest’s commitment to his craft, and a woman, who loves him in spite of his chosen profession.",
            "2018-09-28", 2500000, "http://www.foxsearchlight.com/theoldmanandthegun",
            93))

        data.add(Movie(239.35,1269, "/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
            474350, "en", "It Chapter Two", 7.1,
            "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call.",
            "2019-09-06", 79000000, "http://www.it-movie.net/",
            169))

        data.add(Movie(147.755,2456, "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
            301528,  "en", "Toy Story 4",7.6,
            "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \\\"Forky\\\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
            "2019-06-21", 175000000, "https://www.pixar.com/feature-films-toy-story-4",
            100))

        Log.i("Pelicula Off", ""+data[0])
        online = false
        adapter.data = data
    }

}