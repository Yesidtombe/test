package com.tombe.yesid.example.movies

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tombe.yesid.example.movies.adapters.SerieAdapter
import com.tombe.yesid.example.movies.model.ResultSeries
import com.tombe.yesid.example.movies.model.Serie
import com.tombe.yesid.example.movies.net.ApiClient
import com.tombe.yesid.example.movies.util.Data
import kotlinx.android.synthetic.main.activity_serie.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SerieActivity : AppCompatActivity(), Callback<ResultSeries> {

    val adapter: SerieAdapter = SerieAdapter()
    val data: MutableList<Serie> = mutableListOf()
    var online: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)
        list2.adapter = adapter
        adapter.onSerieSelected = this::goToDetail

        val tipo = intent.extras?.getInt("item")
        title = getString(tipo!!)

        when(tipo){
            R.string.popular_series -> ApiClient.series.getPopularSeries()
                .enqueue(this)
            else -> ApiClient.series.getTopRatedSeries()
                .enqueue(this)
        }
    }

    //region loadData
    fun loadData(lista: List<Serie>){

        lista.forEach {
            data.add(Serie(it.popularity, it.vote_count, it.poster_path, it.id,
                it.original_language, it.genres, it.vote_average, it.overview, it.homepage,
                it.original_name, it.number_of_seasons, it.origin_country, it.created_by,
                it.first_air_date))
            Log.i("Serie", ""+it)
        }
        online = true
        adapter.data = data

    }
    //endregion

    fun goToDetail(position: Int){

        if (online) startActivity<SerieDetailActivity>("movie" to data[position],
            "online" to online)
        else startActivity<SerieDetailActivity>("movie" to Data.data[position],
            "online" to online)

    }

    //region Callback retrofit
    override fun onResponse(call: Call<ResultSeries>, response: Response<ResultSeries>) {
        when(response.code()){
            200 -> {
                val res: ResultSeries = response.body()!!
                loadData(res.results)
            }
            401 -> toast("Invalid API key: You must be granted a valid key")
            else -> toast("¡ Movies not found !")
        }
    }

    override fun onFailure(call: Call<ResultSeries>, t: Throwable) {
        Toast.makeText(this,
            "Error retrieving information. Check your internet connection. The movie data shown are static",
            Toast.LENGTH_LONG).show()
        Log.i("Error ",""+t.message)
        online = false
        adapter.data = Data.data2
    }
    //endregion
}
