package com.nambv.demo.domain.model.feed

import com.nambv.demo.domain.model.base.PublisherNewModel
import com.nambv.demo.domain.model.base.BaseNewInfo

/**
 * Created by nambv on 6/12/2021
 */
data class NewInfoModel(
    val id: Long,

    override val documentId: String?,
    override val title: String?,
    override val description: String?,
    override val publishedDate: String?,
    override val originUrl: String?,
    override val publisherNewModel: PublisherNewModel?,

    val contentType: TypeNew,
    val mainImage: String?,
    val listImage: List<String>?,

    ) : BaseNewInfo {

    fun sameContent(other: NewInfoModel): Boolean {
        return this.title == other.title
                && this.description == other.description
                && this.contentType == other.contentType
                && this.publishedDate == other.publishedDate
                && this.publisherNewModel?.name == other.publisherNewModel?.name
                && this.publisherNewModel?.id == other.publisherNewModel?.id
                && this.publisherNewModel?.iconUrl == other.publisherNewModel?.iconUrl
                && this.mainImage == other.mainImage
    }

}