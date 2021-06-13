package com.nambv.demo.newsappdemo.utils

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestManager

/**
 * Created by nambv on 6/5/2021
 */
fun Fragment.withArgs(bundle: Bundle?) =
    this.apply {
        arguments = bundle
    }

fun Context.toast(message: String) {
    Toast.makeText(
        this, message,
        Toast.LENGTH_LONG
    ).show()
}

fun Context.getRealScreenWidth(): Int {
    val displayMetrics = DisplayMetrics()
    (this as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

fun Context.getOverrideForSizeImageFullWidth(width: Int, height: Int): Array<Int> {
    return arrayOf(getRealScreenWidth(), (height * getRealScreenWidth()) / width)
}

fun View.updateHeight(newHeight: Int) {
    this.layoutParams.height = newHeight
}

fun ImageView.loadImage(
    requestManager: RequestManager,
    holder: Drawable,
    error: Drawable,
    link: String?,
    width: Int,
    height: Int
) {
    requestManager
        .load(link)
        .placeholder(holder)
        .error(error)
        .override(width, height)
        .centerCrop()
        .into(this)
}