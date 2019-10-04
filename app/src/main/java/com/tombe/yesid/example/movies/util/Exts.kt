package com.tombe.yesid.example.movies.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layout: Int):View =
    LayoutInflater.from(context).inflate(layout, this, false)