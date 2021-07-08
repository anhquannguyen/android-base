package com.example.myapplication.extension

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.myapplication.util.NetworkUtils

fun log(msg: Any) {
    Log.d("###LOG", msg.toString())
}

fun Context.toast(msg: String) {
    val isOnMainThread = Looper.myLooper() == Looper.getMainLooper()
    try {
        if (isOnMainThread)
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        else
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun AppCompatActivity.askPermission(
    permission: String,
    result: (Boolean) -> Unit
) {
    this.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        result(it)
    }.launch(permission)
}

fun AppCompatActivity.askPermissions(
    permissions: Array<String>,
    result: (Map<String?, Boolean?>) -> Unit
) {
    this.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        result(it)
    }.launch(permissions)
}

fun Fragment.push(direction: NavDirections, navOpts: NavOptions? = null) {
    try {
        findNavController().navigate(direction, navOpts)
    } catch (e: Throwable) {
        e.printStackTrace()
    }
}

fun Fragment.push(
    @IdRes destinationId: Int,
    bundle: Bundle? = null,
    navOpts: NavOptions? = null
) {
    try {
        findNavController().navigate(destinationId, bundle, navOpts)
    } catch (e: Throwable) {
        e.printStackTrace()
    }
}

fun Fragment.popBackStack(): Boolean = findNavController().popBackStack()

fun Fragment.popBackStack(@IdRes destinationId: Int, inclusive: Boolean = false): Boolean =
    findNavController().popBackStack(destinationId, inclusive)

inline fun <reified T> Context.dpToPx(dp: Float): T {
    val result = dp * (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    when (T::class) {
        Int::class -> result.toInt()
    }
    return result as T
}

fun Context.getDimensionPixelSize(resId: Int): Int = resources.getDimensionPixelSize(resId)

fun Context.getStringArray(resId: Int): List<String> =
    resources.getStringArray(resId).toList()

fun colorStateListOf(vararg mapping: Pair<IntArray, Int>): ColorStateList {
    val (states, colors) = mapping.unzip()
    return ColorStateList(states.toTypedArray(), colors.toIntArray())
}

fun Context.createColorStateList(
    state: Int,
    @ColorRes inActiveColor: Int,
    @ColorRes activeColor: Int
): ColorStateList {
    return ColorStateList(
        arrayOf(intArrayOf(-state), intArrayOf(state)),
        intArrayOf(getColor(inActiveColor), getColor(activeColor))
    )
}

val Context.hideKeyboard: Boolean
    get() {
        return try {
            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (inputManager.isActive) {
                inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
                true
            } else false
        } catch (e: Exception) {
            false
        }
    }

val Context.showKeyboard: Boolean
    get() {
        return try {
            val inputMethodManager =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            inputMethodManager?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            true
        } catch (exception: Exception) {
            false
        }
    }

val Context.hasNetwork: Boolean
    get() = NetworkUtils.isNetworkAvailable(this)
