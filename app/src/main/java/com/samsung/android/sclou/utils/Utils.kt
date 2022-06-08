package com.samsung.android.sclou.utils

import com.samsung.android.sclou.R
import com.samsung.android.sclou.utils.web.WebLifwesbxwxuzmysult
import com.samsung.android.sclou.utils.web.enums.WebLidscloumcomsamsdscloption


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

inline fun <T> webifwesbxwxuzmysCall(action: () -> WebLifwesbxwxuzmysult<T>): WebLifwesbxwxuzmysult<T> {
    return try {
        action()
    } catch (e: Exception) {
        WebLifwesbxwxuzmysult.Eifwesbxwxuzmysor(message = WebLidscloumcomsamsdscloption.valueOf(e.message ?: "empty"))
    }
}