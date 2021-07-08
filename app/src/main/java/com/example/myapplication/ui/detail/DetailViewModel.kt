package com.example.myapplication.ui.detail

import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.data.repository.FoodRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val repository: FoodRepository) : BaseViewModel() {


}