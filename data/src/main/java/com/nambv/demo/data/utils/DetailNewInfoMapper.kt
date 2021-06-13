package com.nambv.demo.data.utils

import com.google.gson.Gson
import com.nambv.demo.data.model.detal.*
import com.nambv.demo.domain.common.Mapper
import com.nambv.demo.domain.model.detail.DetailNewInfoModel
import com.nambv.demo.domain.model.detail.SectionsDetailModel
import com.nambv.demo.domain.model.detail.TypeSessionNew
import com.nambv.demo.domain.model.feed.TypeNew

/**
 * Created by nambv on 6/12/2021
 */
object DetailNewInfoMapper : Mapper<DetailNewInfoData, DetailNewInfoModel> {

    override fun mapModel(from: DetailNewInfoData): DetailNewInfoModel {
        return DetailNewInfoModel(
            from.documentId,
            from.title,
            from.description,
            from.publishedDate,
            from.originUrl,
            from.publisherNewModel,
            from.sections?.filterNotNull()?.map {
                mapSectionData(it)
            }
        )
    }

    private fun mapSectionData(sectionsDetailData: SectionsDetailData): SectionsDetailModel {
        val gson = Gson()
        return when (sectionsDetailData.sectionType) {
            1 -> SectionsDetailModel(
                sectionType = TypeSessionNew.TEXT,
                content = gson.fromJson(sectionsDetailData.content, ContentSectionText::class.java)
            )
            2 -> SectionsDetailModel(
                sectionType = TypeSessionNew.VIDEO,
                content = gson.fromJson(sectionsDetailData.content, ContentSectionVideo::class.java)
            )
            3 -> SectionsDetailModel(
                sectionType = TypeSessionNew.IMAGE,
                content = gson.fromJson(
                    sectionsDetailData.content,
                    ContentOriginalImage::class.java
                )
            )
            else -> SectionsDetailModel(
                sectionType = TypeSessionNew.TEXT,
                content = gson.fromJson(sectionsDetailData.content, ContentSectionText::class.java)
            )
        }
    }

}