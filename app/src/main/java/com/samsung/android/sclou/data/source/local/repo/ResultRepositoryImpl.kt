package com.samsung.android.sclou.data.source.local.repo

import com.samsung.android.sclou.data.dao.ResultsDao
import com.samsung.android.sclou.data.model.ResultModel
import com.samsung.android.sclou.interfaces.ResultsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultsRepositoryImpl @Inject constructor(private val resultsDao: ResultsDao) :
    ResultsRepository {
    override suspend fun saveResult(value: ResultModel) {
        resultsDao.insertResult(value)
    }

    override fun getResults(): Flow<List<ResultModel>> {
        return resultsDao.getResults()
    }
}