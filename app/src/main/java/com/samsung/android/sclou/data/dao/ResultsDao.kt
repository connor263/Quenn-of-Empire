package com.samsung.android.sclou.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samsung.android.sclou.data.model.game.ResultModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResult(value: ResultModel)

    @Query("SELECT * FROM ${ResultModel.TABLE_NAME}")
    fun getResults(): Flow<List<ResultModel>>
}