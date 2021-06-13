package com.nambv.demo.newsappdemo.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.domain.model.base.BaseContentSessionDetail
import com.nambv.demo.domain.model.detail.DetailNewInfoModel
import com.nambv.demo.domain.usecases.GetDetailNewUseCase
import com.nambv.demo.newsappdemo.ui.common.BaseViewModel
import com.nambv.demo.newsappdemo.utils.ResourceDataDetailNewMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: GetDetailNewUseCase
) : BaseViewModel(savedStateHandle) {

    private val _detailNewFeed = useCase
        .getDetailNewData()
        .map {
            ResourceDataDetailNewMapper.mapModel(it as ResourceData<DetailNewInfoModel>)
        }
        .asLiveData(viewModelScope.coroutineContext)

    val detailNewFeed: LiveData<ResourceData<List<BaseContentSessionDetail>>>
        get() = _detailNewFeed

}