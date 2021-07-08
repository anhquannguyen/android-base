package com.example.myapplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.extension.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

open class BaseViewModel : ViewModel() {

    companion object{
        const val ITEM_SIZE = 10
    }

    protected val default = Dispatchers.Default
    protected val io = Dispatchers.IO
    protected val main = Dispatchers.Main
    protected val unconfined = Dispatchers.Unconfined

    val result = MutableLiveData<Any>()

    override fun onCleared() {
        super.onCleared()
    }
}