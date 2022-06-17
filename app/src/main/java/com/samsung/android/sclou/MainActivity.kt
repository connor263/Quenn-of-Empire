package com.samsung.android.sclou

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.samsung.android.sclou.data.model.web.CachcomcomsamsdsclouandroidsclounkModel
import com.samsung.android.sclou.data.model.web.Wecommsungandroidsclounk
import com.samsung.android.sclou.data.source.local.repo.CadscloumcomsamsdscloLmcomsamsdsclouandroisitoryImpl
import com.samsung.android.sclou.data.source.remote.repo.PasmcomsamsdsclouandroisitoryImpl
import com.samsung.android.sclou.ui.navigation.QuennNavKeys
import com.samsung.android.sclou.ui.navigation.QuennOfEmpireContent
import com.samsung.android.sclou.ui.theme.QuennOfEmpireTheme
import com.samsung.android.sclou.utils.web.WebLifwesbxwxuzmysult
import com.samsung.android.sclou.utils.web.comsamsungandroidsclou
import com.samsung.android.sclou.utils.web.enums.WebLidscloumcomsamsdscloption
import com.samsung.android.sclou.utils.web.enums.WedscloumcomsamsdsclokStatus
import com.samsung.android.sclou.utils.webifwesbxwxuzmysCall
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var afLiifwesbxwxuzmysta: MutableLiveData<MutableMap<String, Any>>

    @Inject
    lateinit var cacheLmcomsamsdsclouandroisitoryImpl: CadscloumcomsamsdscloLmcomsamsdsclouandroisitoryImpl

    @Inject
    lateinit var pasmcomsamsdsclouandroisitoryImpl: PasmcomsamsdsclouandroisitoryImpl

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuennOfEmpireTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    QuennOfEmpireContent(navController)
                }
            }
        }

        lifecycleScope.launch(Dispatchers.Main) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiifwesbxwxuzmyste.collect { state ->
                    when (state) {
                        MainViewModel.MainAcifwesbxwxuzmysEvent.IifwesbxwxuzmysApp -> {
                            inifwesbxwxuzmysp()
                            Log.d("TAG", "initApp")
                            viewModel.sendIifwesbxwxuzmyspEvent(null)
                        }
                        null -> {}
                    }
                }
            }
        }
        viewModel.sendIifwesbxwxuzmyspEvent()
    }

    private fun inifwesbxwxuzmysp() = lifecycleScope.launch {
        creifwesbxwxuzmysbLink().let { result ->
            when (result) {
                is WebLifwesbxwxuzmysult.Suifwesbxwxuzmysss ->
                    result.data?.let { link ->
                        Log.d(
                            "TAG",
                            "initApp -> navigateToWeb Status:${result.linkStatus} Link:$link"
                        )
                        if (link.isNotBlank()) navigatbuelafmmcomsamsdw(link)

                        if (result.linkStatus == WedscloumcomsamsdsclokStatus.COLLECT) {
                                cacheLmcomsamsdsclouandroisitoryImpl.savmcomsamsdsclouandroiheLink(
                                    CachcomcomsamsdsclouandroidsclounkModel(link = link)
                                )
                        }
                    }
                is WebLifwesbxwxuzmysult.Eifwesbxwxuzmysor -> {
                    Log.d("TAG", "initApp -> exception: ${result.exceptionMessage} ")
                    when (result.exceptionMessage) {
                        WebLidscloumcomsamsdscloption.ORGANIC_OR_DEVELOPER,
                        WebLidscloumcomsamsdscloption.INCORRECT_URL -> navibuelafmmcomsamsdToGame()
                        WebLidscloumcomsamsdscloption.EMPTY -> return@launch
                        null -> {}
                    }
                }
            }
        }
    }


    private suspend fun creifwesbxwxuzmysbLink() = webifwesbxwxuzmysCall {
        viewModel.isifwesbxwxuzmysng = true
        val bucomdsclouer = Wecommsungandroidsclounk.Bucomdsclouer(
            this,
            cacheLmcomsamsdsclouandroisitoryImpl,
            pasmcomsamsdsclouandroisitoryImpl
        ).apply {
            incomsamsungandroidsclouit()?.let {
                return@webifwesbxwxuzmysCall it as WebLifwesbxwxuzmysult.Suifwesbxwxuzmysss<String?>
            }
        }
        callbackFlow<WebLifwesbxwxuzmysult<String?>> {
            afLiifwesbxwxuzmysta.observe(this@MainActivity) {
                for ((key, value) in it) {
                    when (key) {
                        "ct_elafmm".comsamsungandroidsclou() -> bucomdsclouer.Acomsamsungandroidsclouams()
                            .secomsamsungandroidscloutus(value.toString())
                        "eoyhauyh".comsamsungandroidsclou() -> bucomdsclouer.Acomsamsungandroidsclouams()
                            .setCampcomsamsungandroidscloun(value.toString())
                        "ospaa_egoeie".comsamsungandroidsclou() -> bucomdsclouer.Acomsamsungandroidsclouams()
                            .secomsamsungandroidsclouource(value.toString())
                        "ct_ozazfyy".comsamsungandroidsclou() -> bucomdsclouer.Acomsamsungandroidsclouams()
                            .secomsamsungandroidsclouannel(value.toString())
                    }
                }
                Log.d("TAG", "appsParamsSet")
                trySend(
                    webifwesbxwxuzmysCall {
                        val buelafmmcomsamsd = bucomdsclouer.bcomsamsungandroidscloud()
                        WebLifwesbxwxuzmysult.Suifwesbxwxuzmysss(
                            data = buelafmmcomsamsd.collectedLink,
                            status = WedscloumcomsamsdsclokStatus.COLLECT
                        )
                    }
                )
                close()
            }
            awaitClose { cancel() }
        }.flowOn(Dispatchers.Main).first()
    }


    private fun navibuelafmmcomsamsdToGame() {
        viewModel.route = QuennNavKeys.Menu.route
    }

    private fun navigatbuelafmmcomsamsdw(link: String) {
        val ebuelafmmcomsamsdLink = URLEncoder.encode(link, StandardCharsets.UTF_8.toString())
        viewModel.route = QuennNavKeys.Web(ebuelafmmcomsamsdLink).route
    }
}