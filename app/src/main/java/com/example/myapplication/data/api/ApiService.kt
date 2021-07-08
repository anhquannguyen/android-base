package com.example.myapplication.data.api

import com.example.myapplication.data.api.ApiEndPoint.API_FOOD
import com.example.myapplication.data.model.FoodItem
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET(API_FOOD)
    suspend fun getFoods(@Query("size") size: Int): List<FoodItem>

}