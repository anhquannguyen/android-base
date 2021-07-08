package com.example.myapplication.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity : AppCompatActivity() {
    protected abstract val binding: ViewDataBinding

    protected inline fun <reified T : ViewDataBinding> setBinding(@LayoutRes layoutResId: Int): Lazy<T> =
        lazy {
            DataBindingUtil.setContentView<T>(this, layoutResId)
        }
}