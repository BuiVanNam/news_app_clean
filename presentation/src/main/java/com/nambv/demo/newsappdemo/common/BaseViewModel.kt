package com.nambv.demo.newsappdemo.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    fun <T : Any?> setKeySate(key: String, value: T?) {
        savedStateHandle.set(key, value)
    }

    fun <T> removeKeyState(key: String) {
        savedStateHandle.remove<T>(key)
    }

    fun <T> getKeyState(key: String): T? = savedStateHandle.get<T>(key)

    fun <T> getLiveDataKeyState(key: String, defaultValue: T? = null): LiveData<T> =
        savedStateHandle.getLiveData<T>(key, defaultValue)

}