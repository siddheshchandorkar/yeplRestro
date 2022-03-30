package com.siddhesh.yepl.utils

import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide

class BindingUtils {

    companion object {
        const val ANDROID_SRC = "android:src"
        const val REFRESH_LISTENER = "refreshListener"
        const val TEXT_WATCHER = "textWatcher"

        @JvmStatic
        @BindingAdapter(ANDROID_SRC)
        fun bindImageUrl(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load(url)
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter(REFRESH_LISTENER)
        fun bindSwipeRefreshListener(
            swipeRefreshLayout: SwipeRefreshLayout,
            onRefreshListener: SwipeRefreshLayout.OnRefreshListener
        ) {
            swipeRefreshLayout.setOnRefreshListener(onRefreshListener)
        }

        @JvmStatic
        @BindingAdapter(TEXT_WATCHER)
        fun bindTextWatcher(
            editText: EditText,
            textWatcher: TextWatcher
        ) {
            editText.addTextChangedListener(textWatcher)
        }

    }

}