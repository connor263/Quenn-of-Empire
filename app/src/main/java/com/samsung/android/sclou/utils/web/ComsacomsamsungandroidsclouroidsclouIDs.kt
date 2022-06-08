package com.samsung.android.sclou.utils.web

import android.content.Context
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient

class ComsacomsamsungandroidsclouroidsclouIDs(context: Context) {
    val gocomsamsungandroidscloueID = AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()
    val acomsamsungandroidsclouD = AppsFlyerLib.getInstance().getAppsFlyerUID(context).toString()
}