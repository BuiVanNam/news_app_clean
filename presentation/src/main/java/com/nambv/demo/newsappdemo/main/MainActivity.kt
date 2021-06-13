package com.nambv.demo.newsappdemo.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.nambv.demo.newsappdemo.common.BaseActivity
import com.nambv.demo.newsappdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()

    override fun inflaterViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}