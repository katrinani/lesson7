package com.example.lesson7.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil3.load
import com.example.lesson7.R
import com.example.lesson7.databinding.FragmentMainBinding
import dev.androidbroadcast.vbpd.viewBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dog.setOnClickListener {
            viewModel.loadNewDog()
        }

        viewModel.dogImageUrl.observe(viewLifecycleOwner) {
            binding.dogImage.load(it)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}