package com.example.myapplication.ui.detail

import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.extension.log
import com.example.myapplication.extension.tap

class DetailFragment : BaseFragment() {

    override val binding by dataBinding<FragmentDetailBinding>(R.layout.fragment_detail)
    override val viewModel by viewModels<DetailViewModel> { factory }

    override fun onCreate() {

    }

    override fun onViewCreated() {

    }

}