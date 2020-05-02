package com.lago.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lago.core.assistedViewModels
import com.lago.home.databinding.HomeFragmentBinding
import com.lago.home.di.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    private lateinit var binding: HomeFragmentBinding

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
        return binding.root
    }
}
