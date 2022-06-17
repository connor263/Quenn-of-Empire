package com.samsung.android.sclou.ui.web

import android.annotation.SuppressLint
import android.app.Activity
import android.webkit.CookieManager
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewNavigator
import com.google.accompanist.web.rememberWebViewState
import com.samsung.android.sclou.ui.navigation.QuennNavKeys
import com.samsung.android.sclou.utils.web.WebdscloumcomsamsdscloUtils

@Composable
fun Wedscldscloumcomsamsdscloamsdscloen(navController: NavController, link: String) {
    val sdscloumcomsamsdscloe = rememberWebViewState(url = link)
    val dscloumcomsamsdsclodscloumcomsamsdsclo = rememberWebViewNavigator()

    val wedscloumcomsamsdscloUtils = remember { WebdscloumcomsamsdscloUtils() }

    val startdscloumcomsamsdscloult =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) wedscloumcomsamsdscloUtils.prodscloumcomsamsdscloesult(
                it.data
            )
        }

    WebView(
        captureBackPresses = false,
        navigator = dscloumcomsamsdsclodscloumcomsamsdsclo,
        state = sdscloumcomsamsdscloe,
        chromeClient = wedscloumcomsamsdscloUtils.webdscloumcomsamsdscloeClient(
            startdscloumcomsamsdscloult
        ),
        client = wedscloumcomsamsdscloUtils.webViedscloumcomsamsdsclo { hasError ->
            if (hasError) {
                navController.navigate(QuennNavKeys.Menu.route) {
                    popUpTo(QuennNavKeys.Init.route) { inclusive = true }
                }
            }
        },
        onCreated = {
            indscloumcomsamsdsclobView(it)
            inidscloumcomsamsdsclogs(it)
            idscloumcomsamsdsclookie(it)
        },
    )

    BackHandler {
        if (sdscloumcomsamsdscloe.loadingState is LoadingState.Finished && dscloumcomsamsdsclodscloumcomsamsdsclo.canGoBack ||
            sdscloumcomsamsdscloe.isLoading
        ) {
            dscloumcomsamsdsclodscloumcomsamsdsclo.navigateBack()
        }
    }
}


@Suppress("DEPRECATION")
@SuppressLint("SetJavaScriptEnabled")
fun inidscloumcomsamsdsclogs(webView: WebView) = with(webView.settings) {
    lightTouchEnabled = true
    javaScriptEnabled = true
    setSupportMultipleWindows(false)
    setAppCacheEnabled(true)

}

fun indscloumcomsamsdsclobView(webView: WebView) = with(webView.settings) {

    allowContentAccess = true
    domStorageEnabled = true
    javaScriptCanOpenWindowsAutomatically = true
    builtInZoomControls = true
    useWideViewPort = true
    displayZoomControls = false
    allowFileAccess = true

}

fun idscloumcomsamsdsclookie(webView: WebView) {
    webView.clearCache(false)
    CookieManager.getInstance().setAcceptCookie(true)
    CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
}

