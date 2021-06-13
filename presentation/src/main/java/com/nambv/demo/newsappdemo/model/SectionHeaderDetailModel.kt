package com.nambv.demo.newsappdemo.model

import com.nambv.demo.domain.model.base.BaseContentSessionDetail
import com.nambv.demo.domain.model.base.PublisherNewModel

/**
 * Created by nambv on 6/13/2021
 */
data class SectionHeaderDetailModel(
    val title: String?,
    val description: String?,
    val pubDate: String?,
    val publisher: PublisherNewModel?
) : BaseContentSessionDetail