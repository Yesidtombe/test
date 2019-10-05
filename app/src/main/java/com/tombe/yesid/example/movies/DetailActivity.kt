package com.tombe.yesid.example.movies

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.blue
import androidx.databinding.DataBindingUtil
import androidx.palette.graphics.Palette
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.tombe.yesid.example.movies.databinding.ActivityDetailBinding
import com.tombe.yesid.example.movies.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), Callback {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val movie: Movie? = intent.extras?.getParcelable("movie")

        binding.movie = movie

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Picasso.with(this)
            .load(Uri.parse("http://image.tmdb.org/t/p/original${movie?.img}"))
            .into(img, this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccess() {
        val drawable = img.drawable as BitmapDrawable
        val palette = Palette.from(drawable.bitmap).generate()

        val primaryColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val vibrantColor = palette.getVibrantColor(primaryColor)

        collapsingToolbar.setContentScrimColor(vibrantColor)
        setStatusColot(vibrantColor)
    }

    override fun onError() {

    }

    fun setStatusColot(color: Int){
        var blue = Color.blue(color) - 30
        var red = Color.red(color) - 30
        var green = Color.green(color) - 30

        blue = if(blue < 0) 0 else blue
        red = if (red < 0) 0 else red
        green = if (green < 0) 0 else green

        val statusColor = Color.rgb(red, green, blue)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = statusColor
        }
    }

}