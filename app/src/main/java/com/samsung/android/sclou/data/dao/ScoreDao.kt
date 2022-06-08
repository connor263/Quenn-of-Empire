package com.samsung.android.sclou.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samsung.android.sclou.data.model.game.ScoreModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScore(value: ScoreModel)

    @Query("SELECT * FROM ${ScoreModel.TABLE_NAME}")
    fun getScore(): Flow<ScoreModel>
}