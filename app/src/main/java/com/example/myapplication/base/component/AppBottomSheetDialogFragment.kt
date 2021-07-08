package com.example.myapplication.base.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class AppBottomSheetDialogFragment : BottomSheetDialogFragment() {

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun viewCreated(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewCreated(view, savedInstanceState)
    }
}