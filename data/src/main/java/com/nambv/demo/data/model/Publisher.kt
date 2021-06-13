package com.nambv.demo.data.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import com.nambv.demo.domain.model.base.PublisherNewModel

/**
 * Created by nambv on 6/12/2021
 */
data class Publisher(
    @ColumnInfo(name = "id")
    @SerializedName("id")
    override val id: String?,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    override val name: String?,

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    override val iconUrl: String?,
) : PublisherNewModel
