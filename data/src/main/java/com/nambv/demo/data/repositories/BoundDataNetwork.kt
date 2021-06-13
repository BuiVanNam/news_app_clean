package com.nambv.demo.data.repositories

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.nambv.demo.data.api.ApiResponse
import com.nambv.demo.domain.common.ResourceData
import kotlinx.coroutines.flow.*

/**
 * Created by nambv on 6/12/2021
 */
abstract class BoundDataNetwork<RequestType, ResultType, ResultView> @MainThread constructor() {

    private val resultData = flow {

        emit(
            ResourceData.Loading(data = mapResult(resultType = getCurrentData().first()))
        )
        if (!shouldFetchData()) {
            emitAll(
                getCurrentData().map {
                    ResourceData.Success(data = mapResult(resultType = it))
                }
            )
        } else {
            when (val apiResponse: ApiResponse<RequestType> = createCallApi()) {
                is ApiResponse.ApiSuccess -> {
                    saveDataToDB(mapResponse(apiResponse))
                    emitAll(
                        getCurrentData().map {
                            ResourceData.Success(data = mapResult(resultType = it))
                        }
                    )
                }
                is ApiResponse.ApiError -> {
                    emitAll(
                        getCurrentData().map {
                            ResourceData.Error(
                                data = mapResult(resultType = it),
                                message = "message: ${apiResponse.message} - code: ${apiResponse.code}"
                            )
                        }
                    )
                }
            }
        }
    }

    fun toFlowData() = resultData

    protected abstract fun mapResult(resultType: ResultType): ResultView

    @WorkerThread
    protected abstract suspend fun mapResponse(response: ApiResponse.ApiSuccess<RequestType>): ResultType

    @MainThread
    protected abstract fun shouldFetchData(): Boolean

    @WorkerThread
    protected abstract suspend fun saveDataToDB(data: ResultType)

    @MainThread
    protected abstract fun getCurrentData(): Flow<ResultType>

    @WorkerThread
    protected abstract suspend fun createCallApi(): ApiResponse<RequestType>

}