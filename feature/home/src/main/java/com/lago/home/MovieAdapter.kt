/*
 * Copyright 2020 LagoJin LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lago.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.lago.home.databinding.ItemMovieBinding
import com.lago.model.Movie

class MovieAdapter : PagingDataAdapter<Movie, MovieViewHolder>(movieDiff) {

    private lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickListener)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun interface ItemClickListener {
        fun onClick(movieId: Int)
    }
}

class MovieViewHolder(val view: ItemMovieBinding) : RecyclerView.ViewHolder(view.root) {
    fun bind(item: Movie?, itemClickListener: MovieAdapter.ItemClickListener) {
        view.root.setTag(R.id.tag_movie_id, item!!.id)
        view.apply {
            layout.setOnClickListener {
                itemClickListener.onClick(item.id)
            }
            title.text = item.title
            itemPoster.load("https://image.tmdb.org/t/p/w185_and_h278_bestv2${item.posterPath}")
            itemPoster.transitionName = item.id.toString()
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
