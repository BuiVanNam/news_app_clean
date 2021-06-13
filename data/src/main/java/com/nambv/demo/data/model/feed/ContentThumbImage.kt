package com.nambv.demo.data.model.feed

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import com.nambv.demo.domain.model.base.SectionImageModel

/**
 * Created by nambv on 6/12/2021
 */
data class ContentThumbImage(

    @ColumnInfo(name = "href")
    @SerializedName("href")
    override val linkImage: String?,

    @ColumnInfo(name = "main_color")
    @SerializedName("main_color")
    override val mainColor: String?,

    @ColumnInfo(name = "width")
    @SerializedName("width")
    override val width: Int?,

    @ColumnInfo(name = "height")
    @SerializedName("height")
    override val height: Int?,
) : SectionImageModel {

    override val caption: String? = null

}
