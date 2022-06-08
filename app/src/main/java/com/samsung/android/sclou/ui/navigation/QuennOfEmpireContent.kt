package com.samsung.android.sclou.ui.navigation

import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.samsung.android.sclou.MainActivity
import com.samsung.android.sclou.MainViewModel
import com.samsung.android.sclou.R
import com.samsung.android.sclou.ui.InitScreen
import com.samsung.android.sclou.ui.game.MenuScreen
import com.samsung.android.sclou.ui.game.result.ResultScreen
import com.samsung.android.sclou.ui.game.result.ResultViewModel
import com.samsung.android.sclou.ui.game.slot.SlotScreen
import com.samsung.android.sclou.ui.game.slot.SlotViewModel
import com.samsung.android.sclou.ui.web.Wedscldscloumcomsamsdscloamsdscloen

@Composable
fun QuennOfEmpireContent(navController: NavHostController) {
    val mainViewModel: MainViewModel = hiltViewModel()
    val activity = LocalContext.current as MainActivity
    val originalOrientation = remember { activity.requestedOrientation }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_1),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    NavHost(navController = navController, startDestination = QuennNavKeys.Init.route) {
        composable(QuennNavKeys.Menu.route) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
            MenuScreen(navController)
        }
        composable(QuennNavKeys.Slot.route) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            val viewModel: SlotViewModel = hiltViewModel()
            SlotScreen(viewModel, navController)
        }
        composable(QuennNavKeys.Result.route) {
            val viewModel: ResultViewModel = hiltViewModel()
            ResultScreen(viewModel, navController)
        }


        composable(QuennNavKeys.Init.route) {
            InitScreen()
        }
        composable(QuennNavKeys.Web().route, listOf(
            navArgument("link") {
                type = NavType.StringType
            }
        )) {
            it.arguments?.getString("link")?.let { link ->
                Wedscldscloumcomsamsdscloamsdscloen(navController, link)
            }
        }
    }

    LaunchedEffect(mainViewModel.route) {
        if (mainViewModel.route.isNotBlank()) {
            navController.navigate(mainViewModel.route) {
                popUpTo(QuennNavKeys.Init.route) { inclusive = true }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            activity.requestedOrientation = originalOrientation
        }
    }
}

sealed class QuennNavKeys(val route: String) {
    object Menu : QuennNavKeys("menu")
    object Slot : QuennNavKeys("slot")
    object Result : QuennNavKeys("result")

    object Init : QuennNavKeys("init")
    data class Web(val link: String = "{link}") : QuennNavKeys("web/$link")
}