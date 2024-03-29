package com.tombe.yesid.example.movies.adapters

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tombe.yesid.example.movies.R
import com.tombe.yesid.example.movies.databinding.TemplateMovieBinding
import com.tombe.yesid.example.movies.model.Serie
import com.tombe.yesid.example.movies.util.inflate

class SerieAdapter: RecyclerView.Adapter<SerieHolder>() {

    var onSerieSelected:((position: Int)->Unit)? = null
    var pivote: Boolean = true

    var data: List<Serie> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: SerieHolder, position: Int) {
        holder.bind(pivote,data[position], position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieHolder =
        SerieHolder(parent.inflate(R.layout.template_movie))

    override fun getItemCount(): Int = data.size

    fun onClickSerie(position: Int){
        onSerieSelected?.invoke(position)
    }
}

class SerieHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: TemplateMovieBinding = DataBindingUtil.bind(view)!!

    fun bind(pivot: Boolean,serie: Serie, position: Int, handler: SerieAdapter){
        binding.pivot = pivot
        binding.serie = serie
        binding.position = position
        binding.handler2 = handler
    }

}