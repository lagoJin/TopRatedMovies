package com.lago.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.lago.core.extension.assistedViewModels
import com.lago.home.databinding.HomeFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var viewModelFactory: HomeViewModel.Factory
    private val viewModel: HomeViewModel by assistedViewModels {
        viewModelFactory.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@HomeFragment.viewModel
        }

        movieAdapter = MovieAdapter()

        binding.recyclerView.apply {
            adapter = movieAdapter
            setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            movieAdapter.submitList(movies)
        })

        movieAdapter.setItemClickListener(object : MovieAdapter.ItemClickListener {
            override fun onClick(view: View, movieId: Int) {
                HomeFragmentDirections.actionToDetail(movieId)
            }
        })
    }
}
