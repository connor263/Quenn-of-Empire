package com.samsung.android.sclou.ui.game

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samsung.android.sclou.MainActivity
import com.samsung.android.sclou.R
import com.samsung.android.sclou.ui.game.components.QuennButton
import com.samsung.android.sclou.ui.navigation.QuennNavKeys
import kotlinx.coroutines.launch

@Composable
fun MenuScreen(navController: NavController) {
    val activity = LocalContext.current as MainActivity
    var navigateRoute by remember { mutableStateOf("") }

    val screenHeight = LocalConfiguration.current.screenWidthDp
    val navigationAnim = remember { Animatable(screenHeight + 300F) }
    val imageAnim = remember { Animatable(0F) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        Image(
            modifier = Modifier
                .alpha(imageAnim.value)
                .graphicsLayer { alpha = 0.99f }
                .drawWithContent {
                    val colors = listOf(
                        Color.Transparent,
                        Color.Black
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.horizontalGradient(colors),
                        blendMode = BlendMode.DstIn
                    )
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstIn
                    )
                }
                .offset(x = 100.dp),
            painter = painterResource(id = R.drawable.cleo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .offset(y = navigationAnim.value.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        QuennButton(text = "Play") {
            navigateRoute = QuennNavKeys.Slot.route
        }
        Spacer(modifier = Modifier.height(32.dp))
        QuennButton(text = "Results") {
            navigateRoute = QuennNavKeys.Result.route
        }
        Spacer(modifier = Modifier.height(32.dp))
        QuennButton(text = "Exit") {
            activity.finish()
        }
    }

    LaunchedEffect(Unit) {
        launch {
            navigationAnim.animateTo(
                targetValue = 0F,
                animationSpec = tween(300),
            )
        }
        launch {
            imageAnim.animateTo(
                targetValue = 1F,
                animationSpec = tween(300)
            )
        }
    }

    LaunchedEffect(navigateRoute) {
        if (navigateRoute.isNotBlank()) {
            launch {
                navigationAnim.animateTo(
                    targetValue = (screenHeight + 300F) * -1F,
                    animationSpec = tween(200),
                )
                navController.navigate(navigateRoute)
            }
            launch {
                imageAnim.animateTo(
                    targetValue = 0F,
                    animationSpec = tween(200)
                )
            }
        }
    }
}