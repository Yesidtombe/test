package com.tombe.yesid.example.movies

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.palette.graphics.Palette
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.tombe.yesid.example.movies.databinding.ActivityDetailBinding
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.net.ApiClient
import com.tombe.yesid.example.movies.util.Data
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Response

class DetailActivity : AppCompatActivity(), Callback, retrofit2.Callback<Movie> {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val movie: Int? = intent.extras?.getInt("movie")
        val imagepos: String? = intent.extras?.getString("image")
        val online: Boolean? = intent.extras?.getBoolean("online")

        if(online!!) ApiClient.movies.getMovieDetail(""+movie)
            .enqueue(this)

        else {
            loadData(Data.dataMov[movie!!])
            toast("Data static")
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Picasso.with(this)
            .load(Uri.parse("http://image.tmdb.org/t/p/original${imagepos}"))
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

    //region loadData
    fun loadData(mov: Movie){

        var genero = ""
        var companie = ""
        binding.movie = mov

        mov?.genres?.forEach {
            genero += it.name+", "
        }
        binding.genero = genero

        mov?.production_companies?.forEach {
            companie += it.name+", "
        }
        if (companie == "") companie = "Not specified"
        binding.companie = companie

    }
    //endregion

    //region Callback retrofit
    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

        when(response.code()){
            200 -> {
                val peli: Movie = response.body()!!
                Log.i("Movie", ""+peli)
                loadData(peli)
            }
            401 -> toast("Invalid API key: You must be granted a valid key")
            else -> toast("¡ Movie detail not found !")
        }

    }

    override fun onFailure(call: Call<Movie>, t: Throwable) {
        Toast.makeText(this,
            "Error retrieving information. Check your internet connection. The movie data shown are static",
            Toast.LENGTH_LONG).show()
    }
    //endregion
}