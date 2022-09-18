package com.cjlabs.nasagalleryapp.view.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cjlabs.nasagalleryapp.R

object ImageViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:src")
    fun ImageView.bindImage(url: String) {
        Glide.with(this.context).load(url).into(this)
        if (url.isNullOrEmpty()) {
            this.setImageResource(R.drawable.place_holder)
        } else {
            Glide.with(this.context).load(url).placeholder(R.drawable.place_holder)
                .dontAnimate().into(this)
        }
    }
}