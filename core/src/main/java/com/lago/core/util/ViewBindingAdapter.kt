package com.lago.core.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

@BindingAdapter("srcCoil")
fun srcCoil(imageView: ImageView, uri: String?) {
    uri?.let {
        val base = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"
        imageView.load(base + uri)
    }
}
