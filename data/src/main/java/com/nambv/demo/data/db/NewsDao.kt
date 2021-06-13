package com.nambv.demo.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nambv.demo.data.model.feed.NewInfoData
import kotlinx.coroutines.flow.Flow

/**
 * Created by nambv on 6/12/2021
 */
@Dao
interface NewsDao : BaseDao<NewInfoData> {

    @Transaction
    suspend fun initAllNewsFeed(list: List<NewInfoData>) {
        deleteAllData()
        insertListReplace(list)
    }

    @Query("DELETE FROM new_info")
    suspend fun deleteAllData()

    @Query("SELECT * FROM new_info")
    fun getAllNewsFeed(): Flow<List<NewInfoData>>


}