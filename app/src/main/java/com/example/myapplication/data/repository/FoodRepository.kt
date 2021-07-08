package com.example.myapplication.data.repository

import com.example.myapplication.data.api.ApiService
import com.example.myapplication.data.model.FoodItem
import com.example.myapplication.extension.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class FoodRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getFoods(size: Int): Flow<List<FoodItem>> = flow {
        emit(apiService.getFoods(size))
    }.flowOn(Dispatchers.IO)


}