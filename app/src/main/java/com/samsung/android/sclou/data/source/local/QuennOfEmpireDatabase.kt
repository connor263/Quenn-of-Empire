package com.samsung.android.sclou.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samsung.android.sclou.data.dao.CaccocosungandroidsclouinkDao
import com.samsung.android.sclou.data.dao.ResultsDao
import com.samsung.android.sclou.data.dao.ScoreDao
import com.samsung.android.sclou.data.model.game.ResultModel
import com.samsung.android.sclou.data.model.game.ScoreModel
import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel

@Database(version = 1, entities = [ScoreModel::class, ResultModel::class, CachcomcomsamsdsclouandroidsclounkModel::class])
abstract class QuennOfEmpireDatabase : RoomDatabase() {
    abstract fun getScoreDao(): ScoreDao
    abstract fun getResultsDao(): ResultsDao
    abstract fun getmcomsamsdsclouandroikDao(): CaccocosungandroidsclouinkDao
}