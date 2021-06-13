package com.nambv.demo.data.api

import retrofit2.Response

/**
 * Created by nambv on 6/12/2021
 */
const val ERROR_CODE_UNKNOWN = -1000

sealed class ApiResponse<T> {

    data class ApiSuccess<T>(val data: T) : ApiResponse<T>()
    data class ApiError<T>(val message: String, val code: Int = ERROR_CODE_UNKNOWN) :
        ApiResponse<T>()

    override fun toString(): String {
        return when (this) {
            is ApiSuccess -> "ApiSuccess[data=$data]"
            is ApiError -> "ApiError[message=$message - code=$code]"
        }
    }

}

fun <T> apiResponseFromCallResponse(
    response: Response<T>? = null,
    error: Exception? = null
): ApiResponse<T> {
    if (error != null || response == null) {
        return ApiResponse.ApiError(message = error?.message ?: "UnKnown Error")
    }

    response.run {
        if (!isSuccessful) {
            val message = errorBody()?.string()
            val errorMessage = if (message.isNullOrEmpty()) {
                message()
            } else {
                message
            }
            return ApiResponse.ApiError(message = errorMessage ?: "UnKnown Error", code = code())
        }
        val body = body() ?: return ApiResponse.ApiError(message = "Null body", code = code())
        return ApiResponse.ApiSuccess(data = body)
    }
}
