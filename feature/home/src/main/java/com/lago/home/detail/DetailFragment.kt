package com.lago.home.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.lago.core.extension.assistedViewModels
import com.lago.home.databinding.DetailFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    private lateinit var binding: DetailFragmentBinding

    private val navArgs: DetailFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: DetailViewModel.Factory
    private val viewModel: DetailViewModel by assistedViewModels {
        viewModelFactory.create(navArgs.movie)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@DetailFragment.viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
