package com.samsung.android.sclou.data.source.remote.repo

import com.samsung.android.sclou.data.source.remote.Pastmcomsamsdsclouandroiervice
import com.samsung.android.sclou.interfaces.web.Pastemcomsamsdsclouandroiository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PasmcomsamsdsclouandroisitoryImpl @Inject constructor(private val pasmcomsamsdsclouandroiervice: Pastmcomsamsdsclouandroiervice) : Pastemcomsamsdsclouandroiository {
    override suspend fun fecomsamsungandroidscloundSwitch(callback: suspend(String, Boolean) -> Unit) {
        pasmcomsamsdsclouandroiervice.fetmcomsiamsdsclouandroita().apply {
            ucomsamsungandroidscloul?.let { url ->
                scomsamsungandroidscloutch?.let { switch ->
                    callback(url, switch)
                }
            }
        }
    }
}