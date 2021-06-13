package com.nambv.demo.domain.usecases

import com.nambv.demo.domain.common.BaseFlowUseCase
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.domain.repositories.NewsRepository

/**
 * Created by nambv on 6/12/2021
 */
class GetNewsUseCase(
    private val newsRepository: NewsRepository
) : BaseFlowUseCase<List<NewInfoModel>>() {

    fun getNewsData() = invoke()

    override fun invoke() = newsRepository.getNews()

}