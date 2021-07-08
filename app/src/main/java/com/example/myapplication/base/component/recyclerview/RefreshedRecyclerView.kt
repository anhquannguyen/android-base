package com.example.myapplication.base.component.recyclerview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide.init
import com.example.myapplication.extension.log
import com.example.myapplication.extension.setLinearLayoutManager
import com.example.myapplication.listener.InfiniteScrollListener

class RefreshedRecyclerView : SwipeRefreshLayout {

    private val recyclerView = RecyclerView(context)

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        recyclerView.apply {
            setLinearLayoutManager()
            this@RefreshedRecyclerView.addView(this)
        }
//        setSlingshotDistance(200)
//        setColorSchemeColors(Color.BLACK)
//        setProgressBackgroundColorSchemeColor(Color.WHITE)
//        setProgressViewEndTarget()
//        setProgressViewOffset()
        setOnChildScrollUpCallback { parent, child ->
            false
        }
    }

    fun setup(
        adapter: RecyclerAdapter<*, *>,
        onRefresh: () -> Unit,
        refreshOnStartUp: Boolean = false
    ) {
        setOnRefreshListener {
            onRefresh()
        }

        adapter.setAdapterCallback(object : RecyclerAdapter.OnAdapterCallBack {
            override fun setRefresh(isRefreshing: Boolean) {
                this@RefreshedRecyclerView.isRefreshing = isRefreshing
            }

        })
        recyclerView.adapter = adapter
        this.isRefreshing = refreshOnStartUp
    }

}