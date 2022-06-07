package com.samsung.android.sclou.ui.game.result

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.samsung.android.sclou.ui.game.components.QuennBackButton
import com.samsung.android.sclou.utils.game.randomDecalId
import kotlinx.coroutines.launch

@Composable
fun ResultScreen(viewModel: ResultViewModel = viewModel(), navController: NavHostController) {
    val scope = rememberCoroutineScope()

    val screenHeight = LocalConfiguration.current.screenWidthDp
    val navigationAnim = remember { Animatable(screenHeight + 300F) }

    val results = viewModel.results.collectAsState(initial = null).value

    Box(
        Modifier
            .fillMaxSize()
            .offset(y = navigationAnim.value.dp)
    ) {
        QuennBackButton(Modifier.padding(16.dp)) {
            scope.launch {
                navigationAnim.animateTo(
                    targetValue = (screenHeight + 300F) * -1F,
                    animationSpec = tween(200),
                )
                navController.navigateUp()
            }
        }

        Card(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(top = 96.dp, bottom = 32.dp),
            shape = RoundedCornerShape(24.dp),
            backgroundColor = Color.Yellow.copy(alpha = 0.5F),
            border = BorderStroke(2.dp, Color.White),
        ) {
            if (results?.isNotEmpty() == true) {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(results) {
                        Card(
                            modifier = Modifier.padding(8.dp),
                            shape = RoundedCornerShape(16.dp),
                            backgroundColor = Color.Gray.copy(alpha = 0.9F),
                            border = BorderStroke(2.dp, Color.Black)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    modifier = Modifier.size(46.dp),
                                    painter = painterResource(id = randomDecalId),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(Modifier.height(16.dp))
                                Text(text = "Score: ${it.resultScore}", fontSize = 20.sp)
                                Spacer(Modifier.height(8.dp))
                                Text(text = "Matched: ${it.matched}", fontSize = 20.sp)
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "There are no results...", fontSize = 32.sp)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        launch {
            navigationAnim.animateTo(
                targetValue = 0F,
                animationSpec = tween(300),
            )
        }
    }
}