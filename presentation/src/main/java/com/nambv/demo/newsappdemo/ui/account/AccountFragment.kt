package com.nambv.demo.newsappdemo.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nambv.demo.newsappdemo.ui.common.BaseFragment
import com.nambv.demo.newsappdemo.databinding.FragmentAccountBinding
import com.nambv.demo.newsappdemo.utils.withArgs
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by nambv on 6/13/2021
 */
@AndroidEntryPoint
class AccountFragment : BaseFragment<FragmentAccountBinding, AccountViewModel>() {

    override val mViewModel: AccountViewModel by viewModels()

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAccountBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance(bundle: Bundle?) = AccountFragment().withArgs(bundle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}