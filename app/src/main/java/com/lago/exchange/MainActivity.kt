package com.lago.exchange

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lago.core.assistedActivityViewModels
import com.lago.exchange.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: MainViewModel.Factory
    private val viewModel: MainViewModel by assistedActivityViewModels {
        viewModelFactory.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            viewModel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }

        // findNavController(R.id.nav_graph).navigate(R.id.action_main_to_home)
    }
}
