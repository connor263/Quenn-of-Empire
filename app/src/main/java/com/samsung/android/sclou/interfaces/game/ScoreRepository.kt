package com.samsung.android.sclou.interfaces.game

import com.samsung.android.sclou.data.model.game.ScoreModel
import kotlinx.coroutines.flow.Flow

interface ScoreRepository {
    suspend fun saveScore(value: Int)
    fun getScore(): Flow<ScoreModel>
}