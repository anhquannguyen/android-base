package com.example.myapplication.base.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.example.myapplication.R

abstract class AppDialogFragment<T : ViewBinding> : AppCompatDialogFragment() {

    protected lateinit var binding: T

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun initView(view: View, savedInstanceState: Bundle?, args: Bundle?)

    protected abstract fun viewCreated(args: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog?.setCanceledOnTouchOutside(false)
    }

    override fun getTheme(): Int = R.style.MaterialDialogStyle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater,layoutRes,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view, savedInstanceState, arguments)
        viewCreated(arguments)
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (dialog?.isShowing == true)
            return
        super.show(manager, tag)
    }

    override fun dismiss() {
        if (dialog?.isShowing == false)
            return
        super.dismiss()
    }
}