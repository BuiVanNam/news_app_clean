package com.nambv.demo.data.model.detal

import com.google.gson.annotations.SerializedName

/**
 * Created by nambv on 6/13/2021
 */
data class SectionsDetailData(
    @SerializedName("section_type")
    val sectionType: Int?,

    @SerializedName("content")
    val content: String?,
)
