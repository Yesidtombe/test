package com.tombe.yesid.example.movies.adapters

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tombe.yesid.example.movies.R
import com.tombe.yesid.example.movies.databinding.TemplateMovieBinding
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.util.inflate

class MovieAdapter: RecyclerView.Adapter<MovieHolder>(){

    var onMovieSelected:((position:Int)->Unit)? = null

    var data: List<Movie> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data[position], position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
        MovieHolder(parent.inflate(R.layout.template_movie))

    override fun getItemCount(): Int = data.size

    fun onClickMovie(position: Int){
        onMovieSelected?.invoke(position)
    }

}

class MovieHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: TemplateMovieBinding = DataBindingUtil.bind(view)!!

    fun bind(movie: Movie, position: Int, handler: MovieAdapter){
        binding.movie = movie
        binding.position = position
        binding.handler = handler
    }
}