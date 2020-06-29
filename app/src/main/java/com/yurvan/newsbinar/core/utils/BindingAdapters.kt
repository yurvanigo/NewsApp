package com.yurvan.newsbinar.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.yurvan.newsbinar.R


@BindingAdapter("android:setImageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    if (url.isNullOrBlank()) return
    Picasso.get()
        .load(url)
        .placeholder(R.color.colorAccent)
        .fit()
        .centerCrop()
        .into(view)
}
