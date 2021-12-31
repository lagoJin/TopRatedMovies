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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.lago.core.util.EventObserver
import com.lago.home.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.Job
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
        sharedElementReturnTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.detail_shared_enter)

        postponeEnterTransition(300L, TimeUnit.MILLISECONDS)

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

        movieAdapter.setItemClickListener { movieId ->
            val sharedElement = findPosterImage(
                binding.recyclerView,
                movieId
            )
            val extras = FragmentNavigatorExtras(
                sharedElement to sharedElement.transitionName
            )
            val action = HomeFragmentDirections.actionToDetail(movieId)
            findNavController().navigate(action, extras)
        }

        viewModel.init.observe(viewLifecycleOwner, EventObserver {
            search()
            lifecycleScope.launch {
                /*@OptIn(ExperimentalPagingApi::class)
                movieAdapter.dataRefreshFlow.collect {
                    binding.recyclerView.scrollToPosition(0)
                }*/
            }
        })
    }

    private fun findPosterImage(posters: ViewGroup, movieId: Int): View {
        posters.forEach {
            if (it.getTag(R.id.tag_movie_id) == movieId) {
                return it.findViewById(R.id.item_poster)
            }
        }
        return posters
    }
}
