package com.example.myapplication.ui.home

import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    override val viewModel by viewModels<HomeViewModel> { factory }

    override val binding by dataBinding<FragmentHomeBinding>(R.layout.fragment_home)

    private val foodAdapter = FoodAdapter()

    override fun onCreate() {
        viewModel.foods.observe(this, {
            foodAdapter.insertItems(it, true)
        })
    }

    override fun onViewCreated() {
        initRv()
    }

    private fun initRv() {
        binding.swipe.apply {
            setup(foodAdapter, {
                viewModel.getFoods()
            }, true)
        }
    }


}