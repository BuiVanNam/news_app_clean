package com.nambv.demo.newsappdemo.utils

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

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