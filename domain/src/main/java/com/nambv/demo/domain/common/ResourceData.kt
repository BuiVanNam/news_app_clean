package com.nambv.demo.domain.common

/**
 * Created by nambv on 6/12/2021
 */
sealed class ResourceData<T> {

    data class Success<T>(val data: T) : ResourceData<T>()
    data class Error<T>(val data: T?, val message: String) : ResourceData<T>()
    data class Loading<T>(val data: T?) : ResourceData<T>()

    fun toStringType(): String {
        return when (this) {
            is Success -> "Success[data=$]"
            is Error -> "Error[data=$ - message=$message]"
            is Loading -> "Loading[data=$]"
        }
    }

    fun getCurrentData(): T? {
        return when (this) {
            is Success -> this.data
            is Error -> this.data
            is Loading -> this.data
        }
    }

}