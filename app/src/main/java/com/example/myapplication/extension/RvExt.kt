package com.example.myapplication.extension

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.base.component.recyclerview.HorizontalSpacing
import com.example.myapplication.base.component.recyclerview.VerticalSpacing

fun RecyclerView.setLinearLayoutManager(
    orientation: Int = RecyclerView.VERTICAL,
    reverse: Boolean = false,
    hasFixedSize: Boolean = true
) {
    layoutManager = LinearLayoutManager(this.context, orientation, reverse)
    setHasFixedSize(hasFixedSize)
}

fun RecyclerView.setGridLayoutManager(
    spanCount: Int,
    orientation: Int = RecyclerView.VERTICAL,
    reverse: Boolean = false,
    hasFixedSize: Boolean = true,
): GridLayoutManager {
    layoutManager = GridLayoutManager(this.context, spanCount, orientation, reverse)
    setHasFixedSize(hasFixedSize)
    return layoutManager as GridLayoutManager
}

fun GridLayoutManager.spanSizeLookup(spanSize: (position: Int, spanCount: Int) -> Int) {
    spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return spanSize(position, spanCount)
        }
    }
}

fun RecyclerView.setVerticalSpacing(spanCount: Int, spacing: Int) {
    addItemDecoration(VerticalSpacing(spanCount, spacing, true))
}

fun RecyclerView.setHorizontalSpacing(spanCount: Int, spacing: Int) {
    addItemDecoration(HorizontalSpacing(spanCount, spacing))
}