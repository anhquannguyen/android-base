package com.example.myapplication.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.myapplication.R
import com.example.myapplication.extension.log

class ImageUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("url", "thumbnail", requireAll = false)
        fun ImageView.loadImage(image: Any, sizeMultiplier: Float? = null) {
            val requestOptions = RequestOptions().placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
            val transitionOptions = DrawableTransitionOptions.withCrossFade()

            val requestBuilder = Glide.with(context).load(image)
                .listener(listener)
                .apply(requestOptions)
                .transition(transitionOptions)
            if (sizeMultiplier != null)
                requestBuilder.thumbnail(sizeMultiplier)
            requestBuilder.into(this)
        }

        private val listener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                log(msg = "Source is null")
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                log(msg = "Source is ready")
                return false
            }
        }



    }
}