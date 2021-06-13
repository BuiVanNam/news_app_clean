package com.nambv.demo.data.model.feed

import com.google.gson.annotations.SerializedName
import com.nambv.demo.data.model.feed.NewInfoData

/**
 * Created by nambv on 6/12/2021
 */
data class NewsFeedData(
    @SerializedName("items")
    val listNewsFeed: List<NewInfoData>?,
)