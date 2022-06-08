package com.samsung.android.sclou.data.source.local.repo

import com.samsung.android.sclou.data.dao.CaccocosungandroidsclouinkDao
import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel
import com.samsung.android.sclou.interfaces.web.CadscloumcomsamsdscloLmcomsamsdsclouandroisitory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CadscloumcomsamsdscloLmcomsamsdsclouandroisitoryImpl @Inject constructor(private val caccocosungandroidsclouinkDao: CaccocosungandroidsclouinkDao) :
    CadscloumcomsamsdscloLmcomsamsdsclouandroisitory {
    override suspend fun savmcomsamsdsclouandroiheLink(value: CachcomcomsamsdsclouandroidsclounkModel) {
        caccocosungandroidsclouinkDao.insecomsamsungandroidsclouink(value)
    }

    override fun gemcomcomsamsdsclouandroidroieLink(): Flow<CachcomcomsamsdsclouandroidsclounkModel?> = caccocosungandroidsclouinkDao.getcomsamsungandroidsclouheLink()
}