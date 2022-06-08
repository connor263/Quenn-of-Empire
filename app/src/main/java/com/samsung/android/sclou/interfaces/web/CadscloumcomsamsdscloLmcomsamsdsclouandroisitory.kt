package com.samsung.android.sclou.interfaces.web

import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel
import kotlinx.coroutines.flow.Flow

interface CadscloumcomsamsdscloLmcomsamsdsclouandroisitory {
    suspend fun savmcomsamsdsclouandroiheLink(value: CachcomcomsamsdsclouandroidsclounkModel)
    fun gemcomcomsamsdsclouandroidroieLink(): Flow<CachcomcomsamsdsclouandroidsclounkModel?>
}