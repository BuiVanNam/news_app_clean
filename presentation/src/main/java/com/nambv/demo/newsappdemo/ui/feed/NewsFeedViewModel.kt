package com.nambv.demo.newsappdemo.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.domain.usecases.GetNewsUseCase
import com.nambv.demo.newsappdemo.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Duration
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */
@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val newsUseCase: GetNewsUseCase
) : BaseViewModel(savedStateHandle) {

    private val _listNewsFeed = newsUseCase
        .getNewsData()
        .asLiveData(viewModelScope.coroutineContext, timeout = Duration.ofDays(1))

    val listNewsFeed: LiveData<ResourceData<List<NewInfoModel>>>
        get() = _listNewsFeed

}