package com.nambv.demo.newsappdemo.ui.feed

import androidx.lifecycle.SavedStateHandle
import com.nambv.demo.domain.usecases.GetNewsUseCase
import com.nambv.demo.newsappdemo.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */
@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val newsUseCase: GetNewsUseCase
) : BaseViewModel(savedStateHandle) {

}