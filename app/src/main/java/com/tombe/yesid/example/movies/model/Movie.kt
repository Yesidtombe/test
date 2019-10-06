package com.tombe.yesid.example.movies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(

    @SerializedName("popularity") val popularity : Double,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("poster_path") val poster_path : String?,
    @SerializedName("id") val id : Int,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("original_title") val original_title : String,
    //@SerializedName("genres") val genres : List<Int>?,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("overview") val overview : String?,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("budget") val budget : Int?,
    @SerializedName("homepage") val homepage : String?,
    @SerializedName("runtime") val runtime : Int?
    //@SerializedName("production_companies") val production_companies : List<Int>?

): Parcelable