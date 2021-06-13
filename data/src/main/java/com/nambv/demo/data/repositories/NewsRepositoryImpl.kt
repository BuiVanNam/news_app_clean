package com.nambv.demo.data.repositories

import com.nambv.demo.data.api.ApiResponse
import com.nambv.demo.data.api.NewsService
import com.nambv.demo.data.api.apiResponseFromCallResponse
import com.nambv.demo.data.db.NewsDao
import com.nambv.demo.data.di.DispatcherDefault
import com.nambv.demo.data.di.DispatcherIO
import com.nambv.demo.data.model.feed.NewInfoData
import com.nambv.demo.data.model.feed.NewsFeedData
import com.nambv.demo.data.utils.NewInfoMapper
import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.domain.repositories.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by nambv on 6/12/2021
 */
@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val newsDao: NewsDao,
    @DispatcherDefault private val dispatcherDefault: CoroutineDispatcher,
    @DispatcherIO private val dispatcherIO: CoroutineDispatcher,
) : NewsRepository {

    override fun getNews(): Flow<ResourceData<List<NewInfoModel>>> {
        return object : BoundDataNetwork<NewsFeedData, List<NewInfoData>, List<NewInfoModel>>() {

            override fun mapResult(resultType: List<NewInfoData>): List<NewInfoModel> {
                return resultType.map {
                    NewInfoMapper.mapModel(it)
                }
            }

            override suspend fun mapResponse(response: ApiResponse.ApiSuccess<NewsFeedData>): List<NewInfoData> {
                return withContext(dispatcherDefault) {
                    return@withContext response.data.listNewsFeed ?: emptyList()
                }
            }

            override fun shouldFetchData() = true

            override suspend fun saveDataToDB(data: List<NewInfoData>) {
                withContext(dispatcherIO) {
                    newsDao.initAllNewsFeed(data)
                }
            }

            override fun getCurrentData() = newsDao.getAllNewsFeed()

            override suspend fun createCallApi(): ApiResponse<NewsFeedData> {
                return try {
                    withContext(dispatcherIO) {
                        return@withContext apiResponseFromCallResponse(response = newsService.getNewFeed())
                    }
                } catch (exception: Exception) {
                    apiResponseFromCallResponse(null, exception)
                }
            }

        }.toFlowData()
    }

}