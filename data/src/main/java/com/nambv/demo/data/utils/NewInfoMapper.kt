package com.nambv.demo.data.utils

import com.nambv.demo.data.model.feed.NewInfoData
import com.nambv.demo.domain.common.Mapper
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.domain.model.feed.TypeNew

/**
 * Created by nambv on 6/12/2021
 */
object NewInfoMapper : Mapper<NewInfoData, NewInfoModel> {

    override fun mapModel(from: NewInfoData): NewInfoModel {
        return NewInfoModel(
            from.id,
            from.documentId,
            from.title,
            from.description,
            from.publishedDate,
            from.originUrl,
            from.publisherNewModel,
            mapContentTypeNew(from.contentType),
            mainImage = from.avatarNew?.linkImage ?: if (from.listImages.isNullOrEmpty()) {
                null
            } else {
                from.listImages[0].linkImage
            },
            from.listImages?.filter {
                it.linkImage != null
            }?.map {
                it.linkImage!!
            }
        )
    }

    private fun mapContentTypeNew(contentType: String?): TypeNew {
        return when (contentType) {
            "overview" -> TypeNew.OVERVIEW
            "story" -> TypeNew.STORY
            "gallery" -> TypeNew.GALLERY
            "video" -> TypeNew.VIDEO
            "article" -> TypeNew.ARTICLE
            "long_form" -> TypeNew.LONG_FORM
            else -> TypeNew.ARTICLE
        }
    }

}