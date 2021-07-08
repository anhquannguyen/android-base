package com.example.myapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.data.model.FoodItem
import com.example.myapplication.data.repository.FoodRepository
import com.example.myapplication.extension.getResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: FoodRepository) : BaseViewModel() {
    val foods: MutableLiveData<MutableList<FoodItem>> = MutableLiveData()

    init {
        getFoods()
    }

    fun getFoods() {
        viewModelScope.launch {
            repository.getFoods(ITEM_SIZE).getResult({
                foods.postValue(it.toMutableList())
            })
        }
    }
}