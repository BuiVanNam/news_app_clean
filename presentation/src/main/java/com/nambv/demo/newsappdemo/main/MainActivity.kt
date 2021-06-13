package com.nambv.demo.newsappdemo.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.nambv.demo.newsappdemo.R
import com.nambv.demo.newsappdemo.common.BaseActivity
import com.nambv.demo.newsappdemo.common.FragmentFactory
import com.nambv.demo.newsappdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()

    override fun inflaterViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavigator()
        subscribeUi()
    }

    private fun setupNavigator() {
        binding.navBarBottomMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_new_feed -> mViewModel.setViewMainType(ViewMainType.NEW_FEED)
                R.id.nav_account -> mViewModel.setViewMainType(ViewMainType.ACCOUNT)
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun subscribeUi() {
        mViewModel.mViewMainType.observe(this, {
            val tag: String
            val title: String
            when (it) {
                ViewMainType.NEW_FEED -> {
                    tag = FragmentFactory.SCENE.NEWS_FEED
                    title = resources.getString(R.string.new_feed_title)
                }
                else -> {
                    tag = FragmentFactory.SCENE.ACCOUNT
                    title = resources.getString(R.string.account_title)
                }
            }
            setupToolbar(title)
            showFragmentByState(tag)
        })
    }

    private fun setupToolbar(title: String) {
        supportActionBar?.title = title
    }

    private fun showFragmentByState(tag: String) {
        lifecycleScope.launchWhenStarted {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                val fragmentMain = FragmentFactory.create(
                    tag,
                    supportFragmentManager,
                    null
                )
                val listFragment = supportFragmentManager.fragments
                for (i in listFragment.indices) {
                    hide(listFragment[i])
                }
                if (!fragmentMain.isAdded) {
                    add(R.id.main_container, fragmentMain, tag)
                } else {
                    show(fragmentMain)
                }
            }
        }
    }

}