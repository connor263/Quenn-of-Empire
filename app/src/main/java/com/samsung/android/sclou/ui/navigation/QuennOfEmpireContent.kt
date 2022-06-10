package com.samsung.android.sclou.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.samsung.android.sclou.MainViewModel
import com.samsung.android.sclou.R
import com.samsung.android.sclou.ui.InitScreen
import com.samsung.android.sclou.ui.game.GameScreen
import com.samsung.android.sclou.ui.game.GameViewModel
import com.samsung.android.sclou.ui.game.menu.MenuScreen
import com.samsung.android.sclou.ui.game.score.ScoreScreen
import com.samsung.android.sclou.ui.web.Wedscldscloumcomsamsdscloamsdscloen

@Composable
fun QuennOfEmpireContent(navController: NavHostController) {
    val mainViewModel: MainViewModel = hiltViewModel()

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_1),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    NavHost(navController = navController, startDestination = QuennNavKeys.Init.route) {
        composable(QuennNavKeys.Menu.route) {
            MenuScreen(navController)
        }
        composable(QuennNavKeys.Game.route) {
            val viewModel: GameViewModel = hiltViewModel()
            GameScreen(navController, viewModel)
        }
        composable(QuennNavKeys.Score.route) {
            ScoreScreen(navController)
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
}

sealed class QuennNavKeys(val route: String) {
    object Menu : QuennNavKeys("menu")
    object Game : QuennNavKeys("game")
    object Score : QuennNavKeys("score")

    object Init : QuennNavKeys("init")
    data class Web(val link: String = "{link}") : QuennNavKeys("web/$link")
}