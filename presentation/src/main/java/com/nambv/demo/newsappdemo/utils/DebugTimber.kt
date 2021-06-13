package com.nambv.demo.newsappdemo.utils

import timber.log.Timber

/**
 * Created by nambv on 6/5/2021
 */
open class DebugTimber : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return String.format(
            "%s%s:%s",
            "NewsApp_",
            super.createStackElementTag(element),
            element.lineNumber
        )
    }
}