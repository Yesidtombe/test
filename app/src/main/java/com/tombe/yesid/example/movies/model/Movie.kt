package com.tombe.yesid.example.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie (val img: String,
             val name: String?,
             val duration: Int,
             val releaseDate: String?,
             val overview: String): Parcelable