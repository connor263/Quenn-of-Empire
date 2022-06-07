package com.samsung.android.sclou.ui.game.slot

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.samsung.android.sclou.R
import com.samsung.android.sclou.ui.game.components.QuennBackButton
import com.samsung.android.sclou.ui.game.components.QuennSlotBoard
import com.samsung.android.sclou.utils.game.SLOT_BOARD_COLUMNS
import com.samsung.android.sclou.utils.game.SLOT_BOARD_MATCHED_FOR_WIN
import com.samsung.android.sclou.utils.game.SLOT_BOARD_ROWS
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

@Composable
fun SlotScreen(viewModel: SlotViewModel = hiltViewModel(), navController: NavHostController) {
    val score = viewModel.score.collectAsState(initial = null)

    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp

    val stepX = (screenWidth / (SLOT_BOARD_COLUMNS + 2)).dp
    val stepY = (screenHeight / SLOT_BOARD_ROWS).dp

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        QuennSlotBoard(stepX, stepY)
        Column(
            Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Color.Yellow.copy(alpha = 0.7F),
                border = BorderStroke(2.dp, Color.White),
            ) {
                Column(
                    Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Score: ${score.value?.score ?: 0}")
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Matched: ${viewModel.matchedSlots}",
                        color = if (viewModel.matchedSlots >= SLOT_BOARD_MATCHED_FOR_WIN) Color.White else Color.Black
                    )
                }
            }
            Spacer(Modifier.height(32.dp))
            Image(
                modifier = Modifier
                    .size(stepX * 1.5F, stepY * 1.5F)
                    .clickable {
                        viewModel.rollSlots()
                    }
                    .rotate(90F),
                painter = painterResource(id = R.drawable.custom_decal_1),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Spacer(Modifier.height(32.dp))
            QuennBackButton {
                navController.navigateUp()
            }
        }
    }
    if (viewModel.matchedSlots >= SLOT_BOARD_MATCHED_FOR_WIN) {
        KonfettiView(
            modifier = Modifier.fillMaxSize(),
            parties = listOf(
                Party(
                    speed = 0.3f,
                    maxSpeed = 30f,
                    damping = 0.9f,
                    spread = 360,
                    colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                    position = Position.Relative(0.5, 0.5),
                    emitter = Emitter(duration = 150, TimeUnit.MILLISECONDS).max(125)
                )
            ),
        )
    }
}