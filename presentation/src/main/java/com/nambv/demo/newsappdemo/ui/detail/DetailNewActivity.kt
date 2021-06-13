package com.nambv.demo.newsappdemo.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.nambv.demo.newsappdemo.ui.common.BaseActivity
import com.nambv.demo.newsappdemo.databinding.ActivityDetailNewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNewActivity : BaseActivity<ActivityDetailNewBinding, DetailViewModel>() {

    override val mViewModel: DetailViewModel by viewModels()

    override fun inflaterViewBinding(inflater: LayoutInflater) =
        ActivityDetailNewBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}