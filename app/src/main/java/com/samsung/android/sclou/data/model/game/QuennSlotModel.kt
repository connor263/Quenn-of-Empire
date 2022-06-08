package com.samsung.android.sclou.data.model.game

import androidx.annotation.DrawableRes
import com.samsung.android.sclou.utils.randomDecalId

data class QuennSlotModel(
    var column: Int = 1,
    var row: Int = 1,
    var isMatched: Boolean = false,
    @DrawableRes val drawableRes: Int = randomDecalId,
)