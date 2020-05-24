package com.lago.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.lago.home.databinding.ItemMovieBinding
import com.lago.model.Movie

class MovieAdapter() : ListAdapter<Movie, MovieViewHolder>(movieDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class MovieViewHolder(private val view: ItemMovieBinding) : RecyclerView.ViewHolder(view.root) {
    fun bind(item: Movie) {
        view.apply {
            title.text = item.title
            poster.load("https://image.tmdb.org/t/p/w185_and_h278_bestv2${item.posterPath}")
        }
    }

}

val movieDiff = object : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}
