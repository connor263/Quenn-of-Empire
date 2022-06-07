package com.samsung.android.sclou.interfaces

import com.samsung.android.sclou.data.model.ResultModel
import com.samsung.android.sclou.data.model.ScoreModel
import kotlinx.coroutines.flow.Flow

interface ResultsRepository {
    suspend fun saveResult(value: ResultModel)
    fun getResults(): Flow<List<ResultModel>>
}