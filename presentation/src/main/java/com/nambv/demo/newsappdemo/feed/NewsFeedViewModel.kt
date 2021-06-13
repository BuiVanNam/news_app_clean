package com.nambv.demo.newsappdemo.feed

import androidx.lifecycle.SavedStateHandle
import com.nambv.demo.newsappdemo.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */
@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel(savedStateHandle)