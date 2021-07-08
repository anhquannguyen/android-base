package com.example.myapplication.base.component.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolder<M>(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener { onPressed?.invoke(adapterPosition) }
    }

    abstract val onPressed: ((position: Int) -> Unit)?

    abstract val bind: (item: M) -> Unit
}