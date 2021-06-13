package com.nambv.demo.data.repositories

import com.nambv.demo.data.api.ApiResponse
import com.nambv.demo.data.api.NewsService
import com.nambv.demo.data.api.apiResponseFromCallResponse
import com.nambv.demo.data.di.DispatcherIO
import com.nambv.demo.data.model.detal.DetailNewInfoData
import com.nambv.demo.data.utils.DetailNewInfoMapper
import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.domain.model.detail.DetailNewInfoModel
import com.nambv.demo.domain.repositories.DetailNewRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by nambv on 6/12/2021
 */
@Singleton
class DetailNewRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    @DispatcherIO private val dispatcherIO: CoroutineDispatcher,
) : DetailNewRepository {

    override fun getDetailNew(): Flow<ResourceData<DetailNewInfoModel>> {
        return flow {
            val dataNull: DetailNewInfoModel? = null
            emit(
                ResourceData.Loading(data = dataNull)
            )
            val apiResponse: ApiResponse<DetailNewInfoData> = try {
                withContext(dispatcherIO) {
                    return@withContext apiResponseFromCallResponse(response = newsService.getDetailNew())
                }
            } catch (exception: Exception) {
                apiResponseFromCallResponse(null, exception)
            }
            when (apiResponse) {
                is ApiResponse.ApiSuccess -> {
                    emit(
                        ResourceData.Success(data = DetailNewInfoMapper.mapModel(apiResponse.data))
                    )
                }
                is ApiResponse.ApiError -> {
                    emit(
                        ResourceData.Error(
                            data = dataNull,
                            message = "message: ${apiResponse.message} - code: ${apiResponse.code}"
                        )
                    )
                }
            }
        }
    }

}