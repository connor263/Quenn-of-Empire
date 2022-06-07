package com.samsung.android.sclou.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samsung.android.sclou.data.dao.ResultsDao
import com.samsung.android.sclou.data.dao.ScoreDao
import com.samsung.android.sclou.data.model.ResultModel
import com.samsung.android.sclou.data.model.ScoreModel

@Database(version = 1, entities = [ScoreModel::class, ResultModel::class])
abstract class QuennOfEmpireDatabase : RoomDatabase() {
    abstract fun getScoreDao(): ScoreDao
    abstract fun getResultsDao(): ResultsDao
}