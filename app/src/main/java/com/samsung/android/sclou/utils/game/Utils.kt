package com.samsung.android.sclou.utils.game

import com.samsung.android.sclou.R


val randomDecalId: Int
    get() {
        return listOf(
            R.drawable.decal_1,
            R.drawable.decal_2,
            R.drawable.decal_3,
            R.drawable.decal_4,
            R.drawable.decal_5,
            R.drawable.decal_6,
            R.drawable.decal_7,
            R.drawable.decal_8,
            R.drawable.decal_9,
            R.drawable.decal_11,
            R.drawable.decal_12,
            R.drawable.decal_13,
        ).random()
    }