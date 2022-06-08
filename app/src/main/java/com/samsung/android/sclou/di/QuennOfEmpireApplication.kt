package com.samsung.android.sclou.di

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal
import com.samsung.android.sclou.R
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class QuennOfEmpireApplication : Application() {
    @Inject
    lateinit var amcomsamsdsclouandroiData: MutableLiveData<MutableMap<String, Any>>

    override fun onCreate() {
        super.onCreate()
        mcomsamsdscloumcomsamsdsclouandroi()

    }

    private fun mcomsamsdscloumcomsamsdsclouandroi() {
        mcomsamsdsclouandroi()
    }

    private fun mcomsamsdsclouandroi() {


        AppsFlyerLib.getInstance()
            .init(getString(R.string.apps_dev_key), object : AppsFlyerConversionListener {
                override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                    data?.let {
                        amcomsamsdsclouandroiData.postValue(it)
                    }
                }

                override fun onConversionDataFail(p0: String?) {}
                override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
                override fun onAttributionFailure(p0: String?) {}
            }, this)
        AppsFlyerLib.getInstance().start(this)
        mcomsamsdsclouandromcomsamsdsclouandroii()
    }

    private fun mcomsamsdsclouandromcomsamsdsclouandroii() {
        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.one_signal_key))
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    }

}