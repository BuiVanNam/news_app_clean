package com.nambv.demo.data.model.feed

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.nambv.demo.data.model.Publisher
import com.nambv.demo.domain.model.base.BaseNewInfo

/**
 * Created by nambv on 6/12/2021
 */
@Entity(
    tableName = "new_info"
)
data class NewInfoData(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,

    @ColumnInfo(name = "document_id")
    @SerializedName("document_id")
    override val documentId: String?,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    override val title: String?,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    override val description: String?,

    @ColumnInfo(name = "content_type")
    @SerializedName("content_type")
    val contentType: String?,

    @ColumnInfo(name = "published_date")
    @SerializedName("published_date")
    override val publishedDate: String?,

    @ColumnInfo(name = "origin_url")
    @SerializedName("origin_url")
    override val originUrl: String?,

    @Embedded(prefix = "publisher_")
    @SerializedName("publisher")
    override val publisherNewModel: Publisher?,

    @Embedded(prefix = "avatar_")
    @SerializedName("avatar")
    val avatarNew: ContentThumbImage?,

    @ColumnInfo(name = "images")
    @SerializedName("images")
    val listImages: List<ContentThumbImage>?,
) : BaseNewInfo