package com.nambv.demo.data.model.detal

import com.google.gson.annotations.SerializedName
import com.nambv.demo.domain.model.base.SectionTextModel

/**
 * Created by nambv on 6/12/2021
 */
data class ContentSectionText(

    @SerializedName("text")
    override val text: String?,

    @SerializedName("markups")
    override val markups: List<MarkupTextData?>?,

    ) : SectionTextModel