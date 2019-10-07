package com.tombe.yesid.example.movies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Serie (
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("poster_path") val poster_path : String?,
    @SerializedName("id") val id : Int,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("genres") val genres : List<ArrayGeneral>?,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("overview") val overview : String,
    @SerializedName("homepage") val homepage : String?,
    @SerializedName("original_name") val original_name : String,
    @SerializedName("number_of_seasons") val number_of_seasons : Int?,
    @SerializedName("origin_country") val origin_country : List<Int>,
    @SerializedName("created_by") val created_by : List<ArrayGeneral>?,
    @SerializedName("first_air_date") val first_air_date : String?
): Parcelable

data class ResultSeries(
    @SerializedName("page") val page : Int,
    @SerializedName("total_results") val total_results : Int,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("results") val results : List<Serie>
)