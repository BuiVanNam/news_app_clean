package com.nambv.demo.data.model.detal

import com.google.gson.annotations.SerializedName
import com.nambv.demo.data.model.feed.ContentThumbImage
import com.nambv.demo.domain.model.base.SectionVideoModel

/**
 * Created by nambv on 6/12/2021
 */
data class ContentSectionVideo(

    @SerializedName("href")
    override val link: String?,

    @SerializedName("caption")
    override val caption: String?,

    @SerializedName("preview_image")
    override val previewImage: ContentThumbImage?,

    @SerializedName("duration")
    override val duration: Long?,

    ) : SectionVideoModel