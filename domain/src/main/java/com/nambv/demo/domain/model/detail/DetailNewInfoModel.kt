package com.nambv.demo.domain.model.detail

import com.nambv.demo.domain.model.base.BaseNewInfo
import com.nambv.demo.domain.model.base.PublisherNewModel

/**
 * Created by nambv on 6/13/2021
 */
data class DetailNewInfoModel(
    override val documentId: String?,
    override val title: String?,
    override val description: String?,
    override val publishedDate: String?,
    override val originUrl: String?,
    override val publisherNewModel: PublisherNewModel?,
    val sections: List<SectionsDetailModel>?,
) : BaseNewInfo
