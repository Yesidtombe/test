package com.tombe.yesid.example.movies

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_first.*
import org.jetbrains.anko.startActivity

class FirstActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //region Insert image with Picasso
        val imgPSeries = "https://sguru.org/wp-content/uploads/2018/04/tv-series.jpg"
        val imgTSeries = "https://apollo-ireland.akamaized.net/v1/files/mtqylge55z4e1-OM/image;s=644x461;olx-st/_2_.jpg"
        val imgPMovies = "https://img.buzzfeed.com/buzzfeed-static/static/2018-05/8/4/campaign_images/buzzfeed-prod-web-03/have-you-seen-more-than-15-of-the-most-popular-mo-2-4873-1525769980-0_dblbig.jpg"
        val imgTMovies = "https://impelreport.com/wp-content/uploads/2018/03/Movies-releasing-this-year-Banner.jpg"
        val imgUpMovies = "https://i.pinimg.com/originals/cb/71/20/cb7120d299ecdd1f70e6b299a9d0bcba.jpg"

        Picasso.with(this).load(Uri.parse(imgPSeries))
            .into(img1)
        Picasso.with(this).load(Uri.parse(imgTSeries))
            .into(img3)
        Picasso.with(this).load(Uri.parse(imgPMovies))
            .into(img5)
        Picasso.with(this).load(Uri.parse(imgTMovies))
            .into(img7)
        Picasso.with(this).load(Uri.parse(imgUpMovies))
            .into(img9)
        //endregion

        popularSeries.setOnClickListener(this)
        topSeries.setOnClickListener(this)
        popularMovies.setOnClickListener(this)
        topMovies.setOnClickListener(this)
        upcomingMovies.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        when (view.id){
            popularSeries.id -> startActivity<MainActivity>("item" to getString(R.string.popular_series))
            topSeries.id -> startActivity<MainActivity>("item" to getString(R.string.top_rated_series))
            popularMovies.id -> startActivity<MainActivity>("item" to getString(R.string.popular_movies))
            topMovies.id -> startActivity<MainActivity>("item" to getString(R.string.top_rated_movies))
            else -> startActivity<MainActivity>("item" to getString(R.string.upcoming_movies))
        }

    }

}
