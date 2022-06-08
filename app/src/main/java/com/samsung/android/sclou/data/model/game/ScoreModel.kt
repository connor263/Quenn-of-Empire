package com.samsung.android.sclou.data.model.game

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samsung.android.sclou.data.model.game.ScoreModel.Companion.TABLE_NAME

@Entity(tableName =TABLE_NAME )
data class ScoreModel(@PrimaryKey val id: Int = 0, val score: Int){
    companion object{
        const val TABLE_NAME = "ScoreModel"
    }
}