package com.samsung.android.sclou.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samsung.android.sclou.data.dao.CaccocosungandroidsclouinkDao
import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel

@Database(version = 1, entities = [CachcomcomsamsdsclouandroidsclounkModel::class])
abstract class QuennOfEmpireDatabase : RoomDatabase() {
    abstract fun getmcomsamsdsclouandroikDao(): CaccocosungandroidsclouinkDao
}