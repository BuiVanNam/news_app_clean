package com.nambv.demo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nambv.demo.data.model.feed.NewInfoData
import com.nambv.demo.data.utils.ConvertersRoom

/**
 * Created by nambv on 6/12/2021
 */
@Database(entities = [NewInfoData::class], version = 1)
@TypeConverters(ConvertersRoom::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

}