package com.nambv.demo.newsappdemo.utils

import com.nambv.demo.domain.common.ResourceDataMapper
import com.nambv.demo.domain.model.base.BaseContentSessionDetail
import com.nambv.demo.domain.model.detail.DetailNewInfoModel
import com.nambv.demo.newsappdemo.model.SectionDescriptionModel
import com.nambv.demo.newsappdemo.model.SectionPublisherModel
import com.nambv.demo.newsappdemo.model.SectionTitleModel

/**
 * Created by nambv on 6/13/2021
 */
object ResourceDataDetailNewMapper :
    ResourceDataMapper<DetailNewInfoModel, List<BaseContentSessionDetail>>() {

    override fun mapModelResource(from: DetailNewInfoModel?): List<BaseContentSessionDetail>? {
        if (from == null) {
            return null
        }
        return ArrayList<BaseContentSessionDetail>().apply {
            add(SectionTitleModel(from.title))
            add(SectionDescriptionModel(from.description))
            add(SectionPublisherModel(from.publisherNewModel?.name + " . " + from.publishedDate))
            from.sections?.run {
                this.forEach {
                    add(it.content)
                }
            }
        }
    }

}