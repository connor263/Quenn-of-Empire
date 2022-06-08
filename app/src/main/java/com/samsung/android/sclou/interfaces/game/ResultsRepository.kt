package com.samsung.android.sclou.interfaces.game

import com.samsung.android.sclou.data.model.game.ResultModel
import kotlinx.coroutines.flow.Flow

interface ResultsRepository {
    suspend fun saveResult(value: ResultModel)
    fun getResults(): Flow<List<ResultModel>>
}