package com.tombe.yesid.example.movies

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.palette.graphics.Palette
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.tombe.yesid.example.movies.databinding.ActivityDetailBinding
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.net.ApiClient
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Response

class DetailActivity : AppCompatActivity(), Callback, retrofit2.Callback<Movie> {
    override fun onFailure(call: Call<Movie>, t: Throwable) {
        Log.i("Movie detail", ""+t.message)
        toast("Error: "+t.message)
    }

    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
        val peli: Movie? = response.body()
        binding.movie = peli
        Log.i("Movie detail", ""+peli)
        toast(""+peli!!.original_title)
    }

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val movie: Movie? = intent.extras?.getParcelable("movie")
        val online: Boolean? = intent.extras?.getBoolean("online")
        if (online!!) toast("¡ Online !")
        else toast("¡ Offline !")

//        val pos: Int? = intent.extras?.getInt("movie")
        ApiClient.movies.getMovieDetail(""+movie?.id)
            .enqueue(this)

        //binding.movie = movie
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Picasso.with(this)
            .load(Uri.parse("http://image.tmdb.org/t/p/original${movie?.poster_path}"))
            .into(img, this)
    }

    //region Toolbar/CollapsingBar
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
        setStatusColor(vibrantColor)
    }

    override fun onError() {

    }

    fun setStatusColor(color: Int){
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
    //endregion
}