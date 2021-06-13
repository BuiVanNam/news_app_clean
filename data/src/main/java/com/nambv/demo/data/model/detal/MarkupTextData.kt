package com.nambv.demo.data.model.detal

import com.google.gson.annotations.SerializedName
import com.nambv.demo.domain.model.base.MarkupTextModel

/**
 * Created by nambv on 6/12/2021
 */
data class MarkupTextData(

    @SerializedName("markup_type")
    override val markupType: Int?,

    @SerializedName("start")
    override val start: Int?,

    @SerializedName("end")
    override val end: Int?,

    @SerializedName("href")
    override val href: String?

) : MarkupTextModel