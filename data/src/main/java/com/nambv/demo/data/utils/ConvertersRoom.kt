package com.nambv.demo.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nambv.demo.data.model.feed.ContentThumbImage

/**
 * Created by nambv on 6/12/2021
 */
class ConvertersRoom {

    @TypeConverter
    fun listImageToJson(value: List<ContentThumbImage>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToListImage(value: String) =
        Gson().fromJson(value, Array<ContentThumbImage>::class.java).toList()

}