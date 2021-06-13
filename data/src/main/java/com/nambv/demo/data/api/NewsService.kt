package com.nambv.demo.data.api

import com.nambv.demo.data.model.detal.DetailNewInfoData
import com.nambv.demo.data.model.feed.NewsFeedData
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by nambv on 6/12/2021
 */
interface NewsService {

    @GET("newsfeed.json")
    suspend fun getNewFeed(): Response<NewsFeedData>

    @GET("detail.json")
    suspend fun getDetailNew(): Response<DetailNewInfoData>

}