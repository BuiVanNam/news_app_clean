package com.nambv.demo.newsappdemo

import android.app.Application
import com.nambv.demo.newsappdemo.utils.DebugTimber
import com.nambv.demo.newsappdemo.utils.ReleaseTimber
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTimber())
        } else {
            Timber.plant(ReleaseTimber())
        }
    }

}