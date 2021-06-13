package com.nambv.demo.newsappdemo.utils

import com.nambv.demo.domain.common.Mapper
import com.nambv.demo.domain.model.base.BaseContentSessionDetail
import com.nambv.demo.domain.model.detail.DetailNewInfoModel
import com.nambv.demo.newsappdemo.model.SectionHeaderDetailModel

/**
 * Created by nambv on 6/13/2021
 */
object DetailNewMapper :
    Mapper<DetailNewInfoModel, List<BaseContentSessionDetail>> {

    override fun mapModel(from: DetailNewInfoModel): List<BaseContentSessionDetail> {
        return ArrayList<BaseContentSessionDetail>().apply {
            add(
                SectionHeaderDetailModel(
                    from.title,
                    from.description,
                    from.publishedDate,
                    from.publisherNewModel
                )
            )
            from.sections?.run {
                this.forEach {
                    add(it.content)
                }
            }
        }
    }

}