package com.nambv.demo.newsappdemo.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.newsappdemo.R
import com.nambv.demo.newsappdemo.databinding.ActivityDetailNewBinding
import com.nambv.demo.newsappdemo.ui.common.BaseActivity
import com.nambv.demo.newsappdemo.utils.DetailNewMapper
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailNewActivity : BaseActivity<ActivityDetailNewBinding, DetailViewModel>() {

    override val mViewModel: DetailViewModel by viewModels()

    override fun inflaterViewBinding(inflater: LayoutInflater) =
        ActivityDetailNewBinding.inflate(inflater)

    private val mDetailNewInfoAdapter = DetailNewInfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupForDetailNew()
        subscriberUI()
        setupToolbar()
    }

    private fun setupForDetailNew() {
        binding.listSections.run {
            layoutManager = LinearLayoutManager(this@DetailNewActivity)
            adapter = mDetailNewInfoAdapter
            if (itemAnimator is SimpleItemAnimator) {
                (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun subscriberUI() {
        mViewModel.detailNewFeed.observe(this) {
            Timber.d("subscriberUI - listNews: ${it.toStringType()}")
            when (it) {
                is ResourceData.Loading -> {
                    binding.progressLoad.visibility = View.VISIBLE
                    binding.textStatusLoad.visibility = View.GONE
                }
                is ResourceData.Error -> {
                    binding.progressLoad.visibility = View.GONE
                    binding.textStatusLoad.visibility = View.VISIBLE
                    binding.textStatusLoad.text =
                        resources.getString(R.string.error_load_data) + it.message
                }
                is ResourceData.Success -> {
                    binding.progressLoad.visibility = View.GONE
                    binding.textStatusLoad.visibility = View.GONE
                    mDetailNewInfoAdapter.submitList(
                        DetailNewMapper.mapModel(it.data)
                    )
                }
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.run {
            title = null
            setHomeAsUpIndicator(R.drawable.ic_close)
            setDisplayHomeAsUpEnabled(true)
        };
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        binding.listSections.adapter = null
        super.onDestroy()
    }

}