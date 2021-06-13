package com.nambv.demo.data.model.detal

import com.google.gson.annotations.SerializedName
import com.nambv.demo.data.model.Publisher
import com.nambv.demo.domain.model.base.BaseNewInfo

/**
 * Created by nambv on 6/12/2021
 */
data class DetailNewInfoData(

    @SerializedName("document_id")
    override val documentId: String?,

    @SerializedName("title")
    override val title: String?,

    @SerializedName("description")
    override val description: String?,

    @SerializedName("published_date")
    override val publishedDate: String?,

    @SerializedName("origin_url")
    override val originUrl: String?,

    @SerializedName("publisher")
    override val publisherNewModel: Publisher?,

    @SerializedName("sections")
    val sections: List<SectionsDetailData?>?,

    ) : BaseNewInfo