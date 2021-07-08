package com.example.myapplication.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.myapplication.MyApplication

object NetworkUtils {

    private val TRANSPORTS = arrayOf(
        NetworkCapabilities.TRANSPORT_WIFI,
        NetworkCapabilities.TRANSPORT_CELLULAR,
        NetworkCapabilities.TRANSPORT_ETHERNET
    )

    fun isNetworkAvailable(context: Context? = null): Boolean {
        var result = false
        val connectivityManager: ConnectivityManager = if (context == null) {
            MyApplication.INSTANCE?.applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        } else {
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(network) ?: return false

        for (i in TRANSPORTS) {
            if (networkCapabilities.hasTransport(i)) {
                result = true
                break
            }
        }
        return result
    }
}