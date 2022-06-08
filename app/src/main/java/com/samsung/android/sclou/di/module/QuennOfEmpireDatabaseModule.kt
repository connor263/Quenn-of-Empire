package com.samsung.android.sclou.di.module

import android.app.Application
import androidx.room.Room
import com.samsung.android.sclou.data.dao.CaccocosungandroidsclouinkDao
import com.samsung.android.sclou.data.dao.ResultsDao
import com.samsung.android.sclou.data.dao.ScoreDao
import com.samsung.android.sclou.data.source.local.QuennOfEmpireDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuennOfEmpireDatabaseModule {
    @Provides
    @Singleton
    fun provideQuennOfEmpireDatabase(app: Application): QuennOfEmpireDatabase =
        Room.databaseBuilder(app, QuennOfEmpireDatabase::class.java, "QuennOfEmpireDatabase")
            .build()

    @Provides
    @Singleton
    fun provideScoreDao(db: QuennOfEmpireDatabase): ScoreDao = db.getScoreDao()

    @Provides
    @Singleton
    fun provideResultsDao(db: QuennOfEmpireDatabase): ResultsDao = db.getResultsDao()

    @Provides
    @Singleton
    fun providemcomsamsdsclouandroikDao(db: QuennOfEmpireDatabase): CaccocosungandroidsclouinkDao = db.getmcomsamsdsclouandroikDao()
}