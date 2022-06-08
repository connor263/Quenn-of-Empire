package com.samsung.android.sclou.data.source.local.repo

import com.samsung.android.sclou.data.dao.ScoreDao
import com.samsung.android.sclou.data.model.game.ScoreModel
import com.samsung.android.sclou.interfaces.game.ScoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScoreRepositoryImpl @Inject constructor(private val scoreDao: ScoreDao) : ScoreRepository {
    override suspend fun saveScore(value: Int) {
        scoreDao.insertScore(ScoreModel(score = value))
    }

    override fun getScore(): Flow<ScoreModel> {
        return scoreDao.getScore()
    }
}