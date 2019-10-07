package com.tombe.yesid.example.movies.net

import com.tombe.yesid.example.movies.model.ResultSeries
import com.tombe.yesid.example.movies.model.Serie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SerieApi {

    @GET("tv/popular?api_key=647dadc5b02ab52dc6e5304eecdbd736")
    fun getPopularSeriesAll(): Call<ResultSeries>

    @GET("tv/{id}?api_key=647dadc5b02ab52dc6e5304eecdbd736")
    fun getSerieDetail(@Path("id") id: String): Call<Serie>

}