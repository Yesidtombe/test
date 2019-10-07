package com.tombe.yesid.example.movies.util

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imgUrl")
fun setImageByUrl(image: ImageView, url: String){
    Picasso.with(image.context)
        .load(Uri.parse("http://image.tmdb.org/t/p/original$url"))
        .into(image)
}