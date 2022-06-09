package com.samsung.android.sclou.utils.web

import android.content.Context
import android.provider.Settings

class Apcomsamsungandroidsclouls(private val context: Context) {
    val isDecomsamsungandroidsclouoper
        get() = Settings.Secure.getInt(
            context.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
            0
        ) == 1
}