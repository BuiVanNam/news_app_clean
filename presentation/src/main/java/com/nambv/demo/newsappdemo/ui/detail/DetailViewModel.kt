package com.nambv.demo.newsappdemo.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.nambv.demo.domain.usecases.GetDetailNewUseCase
import com.nambv.demo.newsappdemo.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: GetDetailNewUseCase
) : BaseViewModel(savedStateHandle) {

}