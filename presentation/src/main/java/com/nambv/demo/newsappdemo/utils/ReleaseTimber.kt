package com.nambv.demo.newsappdemo.utils

import android.util.Log

/**
 * Created by nambv on 6/5/2021
 */
class ReleaseTimber : DebugTimber() {

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return when (priority) {
            Log.DEBUG, Log.ERROR, Log.WARN -> false
            else -> super.isLoggable(tag, priority)
        }
    }

}