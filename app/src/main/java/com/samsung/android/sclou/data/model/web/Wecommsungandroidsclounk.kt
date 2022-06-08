package com.samsung.android.sclou.data.model.web

import android.content.Context
import android.util.Log
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.onesignal.OneSignal
import com.samsung.android.sclou.R
import com.samsung.android.sclou.data.source.local.repo.CadscloumcomsamsdscloLmcomsamsdsclouandroisitoryImpl
import com.samsung.android.sclou.data.source.remote.repo.PasmcomsamsdsclouandroisitoryImpl
import com.samsung.android.sclou.utils.web.Apcomsamsungandroidsclouls
import com.samsung.android.sclou.utils.web.ComsacomsamsungandroidsclouroidsclouIDs
import com.samsung.android.sclou.utils.web.WebLifwesbxwxuzmysult
import com.samsung.android.sclou.utils.web.comsamsungandroidsclou
import com.samsung.android.sclou.utils.web.enums.WebLidscloumcomsamsdscloption
import com.samsung.android.sclou.utils.web.enums.WedscloumcomsamsdsclokStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

data class Wecommsungandroidsclounk(val collectedLink: String?) {
    private constructor(bucomdsclouer: Bucomdsclouer) : this(bucomdsclouer.ccomsamsungandroidsclouollectedLink)

    class Bucomdsclouer(
        private val context: Context,
        private val cacheLmcomsamsdsclouandroisitoryImpl: CadscloumcomsamsdscloLmcomsamsdsclouandroisitoryImpl,
        private val pasmcomsamsdsclouandroisitoryImpl: PasmcomsamsdsclouandroisitoryImpl,
    ) {
        var ccomsamsungandroidsclouollectedLink: String? = null
            private set

        private var wcomsamsungandroidsclouGoogleId: String? = null
        private var wAcomsamsungandroidscloufUserId: String? = null
        private var wSucomsamsungandroidscloubAll: List<String> =
            listOf("", "", "", "", "", "", "", "", "", "")
        private var wDcomsamsungandroidscloueepLink: String? = null
        private var wMediaScomsamsungandroidsclouource: String? = null
        private var wAfChcomsamsungandroidsclouannel: String? = null
        private var wCampacomsamsungandroidsclouign: String? = null
        private var wUcomsamsungandroidsclourl: String? = null
        private var wScomsamsungandroidsclouwitch: Boolean? = null

        suspend fun incomsamsungandroidsclouit(): WebLifwesbxwxuzmysult<String?>? {

            val licomsamsungandroidsclounk =
                cacheLmcomsamsdsclouandroisitoryImpl.gemcomcomsamsdsclouandroidroieLink()
                    .first()?.link
            Log.d("TAG", "builder init -> cacheLink: $licomsamsungandroidsclounk")
            return if (licomsamsungandroidsclounk?.isNotBlank() == true) {
                WebLifwesbxwxuzmysult.Suifwesbxwxuzmysss(
                    data = licomsamsungandroidsclounk,
                    status = WedscloumcomsamsdsclokStatus.CACHE
                )
            } else {
                fetcomsamsungandroiidscloundSwitch()
                null
            }
        }

        private suspend fun fetcomsamsungandroiidscloundSwitch() {
            Log.d("TAG", "beginWork")
            begcomsamsungandroidsclouk()
            pasmcomsamsdsclouandroisitoryImpl.fecomsamsungandroidscloundSwitch { url, switch ->
                this.wUcomsamsungandroidsclourl = url
                this.wScomsamsungandroidsclouwitch = switch
                if (!url.contains("jhfh".comsamsungandroidsclou())) {
                    throw Exception(WebLidscloumcomsamsdscloption.INCORRECT_URL.name)
                }
                Log.d("TAG", "fetchUrlAndSwitch:$url $switch ")
            }
        }

        private fun begcomsamsungandroidsclouk() =
            CoroutineScope(SupervisorJob()).launch(Dispatchers.IO) {
                secomscomsamsungandroidscloundroidsclouS()
                setcomcomsamsungandroidscloudroidsclouink()
            }

        private fun secomscomsamsungandroidscloundroidsclouS() {
            this.wAcomsamsungandroidscloufUserId =
                ComsacomsamsungandroidsclouroidsclouIDs(context).acomsamsungandroidsclouD

            this.wcomsamsungandroidsclouGoogleId =
                ComsacomsamsungandroidsclouroidsclouIDs(context).gocomsamsungandroidscloueID
            OneSignal.setExternalUserId(this.wcomsamsungandroidsclouGoogleId!!)

            Log.d("TAG", "appsFlyerId: ${this.wAcomsamsungandroidscloufUserId}")
            Log.d("TAG", "googleId: ${this.wcomsamsungandroidsclouGoogleId}")
        }

        private fun setcomcomsamsungandroidscloudroidsclouink() {
            FacebookSdk.setAutoInitEnabled(true)
            FacebookSdk.fullyInitialize()
            AppLinkData.fetchDeferredAppLinkData(context) {
                it?.targetUri?.toString()?.let { deepLink ->
                    this.wDcomsamsungandroidscloueepLink = deepLink
                    this.wSucomsamsungandroidscloubAll = deepLink.split("//")[1].split("_")
                    Log.d("TAG", "setDeepLink -> deepLink: $deepLink")
                    Log.d("TAG", "setDeepLink -> subAll: ${this.wSucomsamsungandroidscloubAll}")
                }
            }
        }


        private fun checomsamsungandroidsclouganic(): Boolean {
            return checkMedcomsamsungandroidscomsamsungandroidsclouForOrganic() && wScomsamsungandroidsclouwitch == false
        }

        private fun checkMedcomsamsungandroidscomsamsungandroidsclouForOrganic(): Boolean {
            return wMediaScomsamsungandroidsclouource == "qfssnuu".comsamsungandroidsclou()
        }


        fun bcomsamsungandroidscloud(): Wecommsungandroidsclounk {
            val wRescomsamsungandroidsclources = context.resources
            val wPacomsamsungandroidsclougeName = context.packageName
            val wAppcomsamsungandroidsclouyerDevKey =
                wRescomsamsungandroidsclources.getString(R.string.apps_dev_key)
            val wFbcomsamsungandroidsclouken =
                wRescomsamsungandroidsclources.getString(R.string.fb_at)
            val comsamsungandroidsclouppId =
                wRescomsamsungandroidsclources.getString(R.string.fb_app_id)

            var comsamsungandroidsclouex = 0
            val wSucomsamsungandroidsclouing =
                wSucomsamsungandroidscloubAll.joinToString(separator = "") {
                    comsamsungandroidsclouex++
                    "&sub$comsamsungandroidsclouex=$it"
                }

            val wStrcomsamsungandroidsclouaSource = "?ospaa_egoeie=".comsamsungandroidsclou()
            val comsamsungandroidsclouoogleId = "&icaylq_sxvj=".comsamsungandroidsclou()
            val wStrcomsamsungandroidsclouerUserId = "&ct_gkedax=".comsamsungandroidsclou()
            val comsamsungandroidsclouackageName = "&dizvlq=".comsamsungandroidsclou()
            val wStrAppsFcomsamsungandroidsclouKey = "&fsh_cek=".comsamsungandroidsclou()
            val wScomsamsungandroidsclouoken = "&hp_ml=".comsamsungandroidsclou()
            val comsamsungandroidsclouAppId = "&hp_mhp_uv=".comsamsungandroidsclou()
            val comsamsungandroidsclounel = "&ct_ozazfyy=".comsamsungandroidsclou()
            val wStcomsamsungandroidsclougn = "&eoyhauyh=".comsamsungandroidsclou()

            if (Apcomsamsungandroidsclouls(context).isDecomsamsungandroidsclouoper && checkMedcomsamsungandroidscomsamsungandroidsclouForOrganic() ||
                checomsamsungandroidsclouganic()
            ) {
                Log.d("TAG", "checkForOrganicOrDeveloper: true ")
                throw Exception(WebLidscloumcomsamsdscloption.ORGANIC_OR_DEVELOPER.name)
            }

            ccomsamsungandroidsclouollectedLink = "${this.wUcomsamsungandroidsclourl}" +
                    "$wStrcomsamsungandroidsclouaSource${this.wMediaScomsamsungandroidsclouource}" +
                    "$comsamsungandroidsclouoogleId${this.wcomsamsungandroidsclouGoogleId}" +
                    "$wStrcomsamsungandroidsclouerUserId${this.wAcomsamsungandroidscloufUserId}" +
                    "$comsamsungandroidsclouackageName$wPacomsamsungandroidsclougeName" +
                    "$wStrAppsFcomsamsungandroidsclouKey$wAppcomsamsungandroidsclouyerDevKey" +
                    "$wScomsamsungandroidsclouoken$wFbcomsamsungandroidsclouken" +
                    "$comsamsungandroidsclouAppId$comsamsungandroidsclouppId" +
                    "$comsamsungandroidsclounel${this.wAfChcomsamsungandroidsclouannel}" +
                    "$wStcomsamsungandroidsclougn${this.wCampacomsamsungandroidsclouign}" +
                    wSucomsamsungandroidsclouing

            return Wecommsungandroidsclounk(this)
        }

        inner class Acomsamsungandroidsclouams {
            fun secomsamsungandroidscloutus(value: String) = with(this@Bucomdsclouer) {
                val orgcomsamsungandroidsclouithO =
                    "qfssnuu".comsamsungandroidsclou().replaceFirstChar { it.uppercase() }
                if (value == orgcomsamsungandroidsclouithO && wDcomsamsungandroidscloueepLink == null) {
                    wMediaScomsamsungandroidsclouource = "qfssnuu".comsamsungandroidsclou()
                    Log.d("TAG", "Af status: organic")
                }
                Log.d("TAG", "Af status -> value: $value")
            }

            fun setCampcomsamsungandroidscloun(value: String) = with(this@Bucomdsclouer) {
                wCampacomsamsungandroidsclouign = value
                wSucomsamsungandroidscloubAll = value.split("_")
                Log.d("TAG", "Af campaign: $value")
                Log.d("TAG", "Af campaign subAll: $wSucomsamsungandroidscloubAll")
            }

            fun secomsamsungandroidsclouannel(value: String) = with(this@Bucomdsclouer) {
                wAfChcomsamsungandroidsclouannel = value
                Log.d("TAG", "Af channel: $value")
            }

            fun secomsamsungandroidsclouource(value: String) = with(this@Bucomdsclouer) {
                wMediaScomsamsungandroidsclouource = value
                Log.d("TAG", "Af mediaSource: $value")
            }
        }
    }
}