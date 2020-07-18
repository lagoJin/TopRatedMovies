package com.lago.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.ExperimentalPagingApi
import com.lago.core.options
import com.lago.core.util.EventObserver
import com.lago.home.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter() }

    private val viewModel by viewModels<HomeViewModel>()

    private var searchJob: Job? = null

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

        return binding.root
    }

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.searchRepo().collectLatest {
                movieAdapter.submitData(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = movieAdapter
            setHasFixedSize(true)
        }

        movieAdapter.setItemClickListener(object : MovieAdapter.ItemClickListener {
            override fun onClick(view: View, movieId: Int) {
                findNavController().navigate(
                    HomeFragmentDirections.actionToDetail(movieId),
                    options
                )
            }
        })

        viewModel.init.observe(viewLifecycleOwner,
            EventObserver {
                search()
                lifecycleScope.launch {
                    @OptIn(ExperimentalPagingApi::class)
                    movieAdapter.dataRefreshFlow.collect {
                        binding.recyclerView.scrollToPosition(0)
                    }
                }
            })
    }

    companion object {
        const val RECYCLERVIEW_KEY = "RECYCLERVIEW_KEY"
    }
}
