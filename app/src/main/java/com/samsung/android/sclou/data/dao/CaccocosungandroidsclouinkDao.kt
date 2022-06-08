package com.samsung.android.sclou.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CaccocosungandroidsclouinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insecomsamsungandroidsclouink(value: CachcomcomsamsdsclouandroidsclounkModel)

    @Query("SELECT * FROM ${CachcomcomsamsdsclouandroidsclounkModel.TABLE_NAME}")
    fun getcomsamsungandroidsclouheLink(): Flow<CachcomcomsamsdsclouandroidsclounkModel?>
}