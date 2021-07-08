package com.example.myapplication.data.api

suspend inline fun <T> safeApiCall(crossinline body: () -> T): T? {
    return try {
        body.invoke()
    }catch (e:Exception){
        null
    }
}