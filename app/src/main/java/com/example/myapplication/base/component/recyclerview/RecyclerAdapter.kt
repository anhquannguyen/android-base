package com.example.myapplication.base.component.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerAdapter<D : ViewDataBinding, M> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var _isRefreshing = false

    protected val items: MutableList<M> = mutableListOf()

    private lateinit var onAdapterCallBack: OnAdapterCallBack

    fun setAdapterCallback(callBack: OnAdapterCallBack) {
        onAdapterCallBack = callBack
    }

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun setHolder(binding: D): ViewHolder<M>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        if (_isLoadingState) {
//            val binding: ViewIndicatorBinding = DataBindingUtil.inflate(
//                LayoutInflater.from(parent.context),
//                R.layout.view_indicator,
//                parent,
//                false
//            )
//            return IndicatorHolder(binding)
//        }

        val binding: D = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
        return setHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder<M>).bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun insertItems(
        newItems: MutableList<M>?,
        isRefreshing: Boolean
    ) {
        if (newItems == null) return
        if (isRefreshing) {
            items.clear()
        }
        items.addAll(0, newItems)
        if (isRefreshing) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeInserted(0, newItems.size)
        }
        onAdapterCallBack.setRefresh(false)
    }

//        override fun getItemViewType(position: Int): Int {
//        if (items.isEmpty()) {
//            _isLoadingState = true
//            return State.FIRST_LOADING.ordinal
//        } else {
//            _isLoadingState = false
//            return State.ITEM.ordinal
//        }
//    }

//    class IndicatorHolder(binding: ViewIndicatorBinding) : ViewHolder<Int>(binding) {
//
//        override val onPressed: ((position: Int) -> Unit)?
//            get() = null
//
//        override val bind: (item: Int) -> Unit
//            get() = {
//            }
//
//    }

//        enum class State(type: Int) {
//        FIRST_LOADING(1), LOAD_INFINITE(2), ITEM(3)
//    }

    interface OnAdapterCallBack {
        fun setRefresh(isRefreshing: Boolean)
    }

}