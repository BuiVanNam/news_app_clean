package com.nambv.demo.domain.repositories

import com.nambv.demo.domain.common.ResourceData
import com.nambv.demo.domain.model.feed.NewInfoModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by nambv on 6/12/2021
 */
interface NewsRepository {

    fun getNews(): Flow<ResourceData<List<NewInfoModel>>>

}