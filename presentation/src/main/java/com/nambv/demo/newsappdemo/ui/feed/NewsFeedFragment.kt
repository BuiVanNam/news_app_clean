package com.nambv.demo.newsappdemo.ui.feed

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.newsappdemo.R
import com.nambv.demo.newsappdemo.ui.common.BaseFragment
import com.nambv.demo.newsappdemo.databinding.FragmentNewsFeedBinding
import com.nambv.demo.newsappdemo.utils.toast
import com.nambv.demo.newsappdemo.utils.withArgs
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Created by nambv on 6/13/2021
 */
@AndroidEntryPoint
class NewsFeedFragment : BaseFragment<FragmentNewsFeedBinding, NewsFeedViewModel>() {

    override val mViewModel: NewsFeedViewModel by viewModels()

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewsFeedBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance(bundle: Bundle?) = NewsFeedFragment().withArgs(bundle)
    }

    private val mNewFeedAdapter = NewInfoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupForListNews()
        subscriberUI()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupForListNews() {
        binding.listNews.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mNewFeedAdapter
            if (itemAnimator is SimpleItemAnimator) {
                (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            }
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                ).apply {
                    setDrawable(resources.getDrawable(R.drawable.divider_new))
                }
            )
        }
    }

    @SuppressLint("SetTextI18n")
    private fun subscriberUI() {
        mViewModel.listNewsFeed.observe(viewLifecycleOwner) {
            val resourceData = it.getCurrentData()
            Timber.d("subscriberUI - listNews: ${it.toStringType()} + sizeData: ${resourceData?.size ?: "null"}")
            when (it) {
                is ResourceData.Loading -> {
                    binding.progressLoad.visibility = View.VISIBLE
                    binding.textStatusLoad.visibility = View.GONE
                }
                is ResourceData.Error -> {
                    val stringError = resources.getString(R.string.error_load_data) + it.message
                    binding.progressLoad.visibility = View.GONE
                    if (resourceData.isNullOrEmpty()) {
                        binding.textStatusLoad.visibility = View.VISIBLE
                        binding.textStatusLoad.text = stringError
                    } else {
                        binding.textStatusLoad.visibility = View.GONE
                        requireContext().toast(stringError)
                    }
                }
                is ResourceData.Success -> {
                    binding.progressLoad.visibility = View.GONE
                    if (resourceData.isNullOrEmpty()) {
                        binding.textStatusLoad.visibility = View.VISIBLE
                        binding.textStatusLoad.text = resources.getString(R.string.no_data)
                    } else {
                        binding.textStatusLoad.visibility = View.GONE
                    }
                }
            }
            mNewFeedAdapter.submitList(
                if (resourceData.isNullOrEmpty()) {
                    emptyList()
                } else {
                    resourceData
                }
            )
        }
    }

    override fun onDestroyView() {
        binding.listNews.adapter = null
        super.onDestroyView()
    }


}