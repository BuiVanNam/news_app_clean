package com.nambv.demo.newsappdemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import com.nambv.demo.newsappdemo.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by nambv on 6/13/2021
 */

private const val VIEW_MAIN_TYPE_KEY = "view_main_type_key"

@HiltViewModel
class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel(savedStateHandle) {

    fun setViewMainType(viewMainType: ViewMainType) {
        mViewMainType.value?.let {
            if (viewMainType != it) {
                setKeySate(VIEW_MAIN_TYPE_KEY, viewMainType)
            }
        }
    }

    val mViewMainType: LiveData<ViewMainType> =
        getLiveDataKeyState(VIEW_MAIN_TYPE_KEY, ViewMainType.NEW_FEED)

}