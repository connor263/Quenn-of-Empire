package com.samsung.android.sclou.data.model.web

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CachcomcomsamsdsclouandroidsclounkModel(@PrimaryKey val id: Int = 0, val link: String){
    companion object{
        const val TABLE_NAME = "CacheLinkModel"
    }
}