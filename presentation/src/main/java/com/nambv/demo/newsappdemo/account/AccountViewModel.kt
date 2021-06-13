package com.nambv.demo.newsappdemo.account

import androidx.lifecycle.SavedStateHandle
import com.nambv.demo.newsappdemo.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */
@HiltViewModel
class AccountViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel(savedStateHandle)