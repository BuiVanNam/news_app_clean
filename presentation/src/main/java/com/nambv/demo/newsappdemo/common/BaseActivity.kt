package com.nambv.demo.newsappdemo.common

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var binding: T

    abstract val mViewModel: V

    abstract fun inflaterViewBinding(inflater: LayoutInflater): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflaterViewBinding(inflater = layoutInflater)
        setContentView(binding.root)
        setupConfig()
    }

    open fun setupConfig() {

    }

}