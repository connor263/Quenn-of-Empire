package com.samsung.android.sclou.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samsung.android.sclou.data.model.ResultModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ResultModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val resultScore: Int,
    val matched: Int
) {
    companion object {
        const val TABLE_NAME = "ResultModel"
    }
}