package com.tombe.yesid.example.movies.net

import com.tombe.yesid.example.movies.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

//    @GET("movie/popular?api_key={apikey}")
//    fun getPopularMovieAll(@Path("apikey") key: String):Call<Result>

    @GET("movie/popular?api_key=647dadc5b02ab52dc6e5304eecdbd736")
    fun getPopularMovieAll():Call<Result>

}