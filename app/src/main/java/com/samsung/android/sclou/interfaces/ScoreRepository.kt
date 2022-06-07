package com.samsung.android.sclou.interfaces

import com.samsung.android.sclou.data.model.ScoreModel
import kotlinx.coroutines.flow.Flow

interface ScoreRepository {
    suspend fun saveScore(value: Int)
    fun getScore(): Flow<ScoreModel>
}