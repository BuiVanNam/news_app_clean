package com.nambv.demo.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Created by nambv on 6/12/2021
 */
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReplace(value: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIgnore(value: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListReplace(values: List<T>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListIgnore(values: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateReplace(value: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateListReplace(values: List<T>)

    @Delete
    suspend fun delete(value: T)

    @Delete
    suspend fun deleteList(values: List<T>)

}