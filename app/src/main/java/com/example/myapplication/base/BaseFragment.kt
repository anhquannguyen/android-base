package com.example.myapplication.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.ViewModelProviderFactory
import com.example.myapplication.extension.popBackStack
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    protected lateinit var factory: ViewModelProviderFactory

    private val pressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressed()
        }
    }

    protected lateinit var inflater: LayoutInflater
    protected lateinit var container: ViewGroup

    protected abstract val binding: ViewDataBinding

    protected abstract val viewModel: BaseViewModel

    protected open val getVariable: Int = 0

    protected abstract fun onCreate()

    protected abstract fun onViewCreated()

    protected inline fun <reified B : ViewDataBinding> Fragment.dataBinding(
        @LayoutRes layoutResId: Int
    ): Lazy<B> {
        return lazy { DataBindingUtil.inflate(inflater, layoutResId, container, false) }
    }

    protected open fun onBackPressed() {
        if (!popBackStack()) requireActivity().finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        addBackPressedCallback()
        onCreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return performBinding(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onViewCreated()
    }

    override fun onDestroy() {
        removeBackPressedCallBack()
        super.onDestroy()
    }

    private fun performBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.container = container!!
        this.inflater = inflater
        if (getVariable != 0) {
            binding.setVariable(getVariable, viewModel)
        }
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        return binding.root
    }

    private fun addBackPressedCallback() {
        requireActivity().onBackPressedDispatcher.addCallback(this, pressedCallback)
    }

    private fun removeBackPressedCallBack() {
        pressedCallback.remove()
    }

}