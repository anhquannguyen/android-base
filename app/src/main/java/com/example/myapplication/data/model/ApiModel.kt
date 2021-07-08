package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class FoodItem(
    @SerializedName("description")
    val description: String?,
    @SerializedName("dish")
    val dish: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("ingredient")
    val ingredient: String?,
    @SerializedName("measurement")
    val measurement: String?,
    @SerializedName("uid")
    val uid: String?
)

data class NationItem(
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("national_sport")
    val nationalSport: String?,
    @SerializedName("nationality")
    val nationality: String?,
    @SerializedName("uid")
    val uid: String?
)