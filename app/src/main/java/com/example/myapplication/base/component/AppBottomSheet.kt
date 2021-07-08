package com.example.myapplication.base.component

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.example.myapplication.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

abstract class AppBottomSheet(private val mContext: Context) : BottomSheetDialog(mContext) {

    protected lateinit var bottomSheet: View
    protected lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        initView(savedInstanceState)
    }

    override fun show() {
        setupDialogBackground()
        super.show()
    }

    private fun setupDialogBackground() {
        this.setOnShowListener { dialog ->
            setCancelable(true)
            val d = dialog as BottomSheetDialog
            bottomSheet =
                d.findViewById(R.id.design_bottom_sheet) ?: return@setOnShowListener
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheet.background = null
        }
    }
}