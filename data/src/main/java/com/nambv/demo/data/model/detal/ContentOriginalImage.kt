package com.nambv.demo.data.model.detal

import com.google.gson.annotations.SerializedName
import com.nambv.demo.domain.model.base.SectionImageModel

/**
 * Created by nambv on 6/12/2021
 */
data class ContentOriginalImage(

    @SerializedName("href")
    override val linkImage: String?,

    @SerializedName("main_color")
    override val mainColor: String?,

    @SerializedName("original_width")
    override val width: Int?,

    @SerializedName("original_height")
    override val height: Int?,

    @SerializedName("caption")
    override val caption: String?,
) : SectionImageModel
