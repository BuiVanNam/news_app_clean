package com.nambv.demo.newsappdemo.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.nambv.demo.newsappdemo.account.AccountFragment
import com.nambv.demo.newsappdemo.feed.NewsFeedFragment
import timber.log.Timber

/**
 * Created by nambv on 6/5/2021
 */
object FragmentFactory {

    object SCENE {
        const val NEWS_FEED = "new_feed"
        const val ACCOUNT = "account"
    }

    fun create(tag: String, fragmentManager: FragmentManager, bundle: Bundle? = null): Fragment {
        Timber.d("create fragment: $tag - $fragmentManager")
        return fragmentManager.findFragmentByTag(tag) ?: createFragmentByTag(tag, bundle)
    }

    private fun createFragmentByTag(tag: String, bundle: Bundle?): Fragment {
        return when (tag) {
            SCENE.NEWS_FEED -> NewsFeedFragment.newInstance(bundle)
            SCENE.ACCOUNT -> AccountFragment.newInstance(bundle)
            else -> throw UnsupportedOperationException("Tag $tag not yet define")
        }
    }

}