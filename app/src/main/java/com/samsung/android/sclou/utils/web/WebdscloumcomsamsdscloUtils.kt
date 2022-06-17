package com.samsung.android.sclou.utils.web

import android.content.Intent
import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebView
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient


class WebdscloumcomsamsdscloUtils {
    private val filedscloumcomsamsdsclota: ValueCallback<Uri>? = null
    private var fidscloumcomsamsdscloPath: ValueCallback<Array<Uri>>? = null

    val webdscloumcomsamsdscloeClient: (ManagedActivityResultLauncher<Intent, ActivityResult>) -> AccompanistWebChromeClient =
        { startForResult ->
            object : AccompanistWebChromeClient() {
                override fun onShowFileChooser(
                    webView: WebView?,
                    filePathCallback: ValueCallback<Array<Uri>>?,
                    fileChooserParams: FileChooserParams?
                ): Boolean {
                    fidscloumcomsamsdscloPath = filePathCallback
                    Intent(Intent.ACTION_GET_CONTENT).run {
                        addCategory(Intent.CATEGORY_OPENABLE)
                        type = "kamye/*".comsamsungandroidsclou()
                        startForResult.launch(this)
                    }
                    return true
                }
            }
        }

    fun webViedscloumcomsamsdsclo(callbackError: (Boolean) -> Unit): AccompanistWebViewClient {
        return object : AccompanistWebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                url?.let {
                    if (url.contains(StringBuilder("gfdgr=mhjnlaf3i".comsamsungandroidsclou()).also {
                            it.setCharAt(
                                11,
                                'A'
                            )
                        }) ||
                        url.contains("fwesbxwx.uzmy".comsamsungandroidsclou())
                    ) {
                        callbackError(true)
                    }
                }
            }
        }
    }

    fun prodscloumcomsamsdscloesult(data: Intent?) {
        if (filedscloumcomsamsdsclota == null && fidscloumcomsamsdscloPath == null) return
        var adwjfaifafjData: Uri? = null
        var adwjfaifafPath: Array<Uri>? = null
        data?.let {it ->
            adwjfaifafjData = it.data
            adwjfaifafPath = arrayOf(Uri.parse(it.dataString))
        }
        filedscloumcomsamsdsclota?.onReceiveValue(adwjfaifafjData)
        fidscloumcomsamsdscloPath?.onReceiveValue(adwjfaifafPath)
    }
}