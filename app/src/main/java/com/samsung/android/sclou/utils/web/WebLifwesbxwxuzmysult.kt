package com.samsung.android.sclou.utils.web

import com.samsung.android.sclou.utils.web.enums.WebLidscloumcomsamsdscloption
import com.samsung.android.sclou.utils.web.enums.WedscloumcomsamsdsclokStatus

sealed class WebLifwesbxwxuzmysult<T>(
    val data: T? = null,
    val linkStatus: WedscloumcomsamsdsclokStatus? = null,
    val exceptionMessage: WebLidscloumcomsamsdscloption? = null
) {
    class Suifwesbxwxuzmysss<T>(
        data: T? = null,
        status: WedscloumcomsamsdsclokStatus
    ) : WebLifwesbxwxuzmysult<T>(data, status)

    class Eifwesbxwxuzmysor<T>(
        data: T? = null,
        message: WebLidscloumcomsamsdscloption
    ) :
        WebLifwesbxwxuzmysult<T>(data, exceptionMessage = message)
}
