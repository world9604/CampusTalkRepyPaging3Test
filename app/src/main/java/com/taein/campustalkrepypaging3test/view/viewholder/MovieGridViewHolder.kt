package com.taein.paging3test.view.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.taein.campustalkrepypaging3test.R
import com.taein.campustalkrepypaging3test.databinding.MovieGridItemBinding
import com.taein.paging3test.data.model.Movies

class MovieGridViewHolder(private val binding: MovieGridItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movies.Movie) {
        with(movie) {
            binding.poster.load(poster?.medium) {
                crossfade(true)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieGridViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_grid_item,  parent,false)

            val binding = MovieGridItemBinding.bind(view)

            return MovieGridViewHolder(
                binding
            )
        }
    }
}
