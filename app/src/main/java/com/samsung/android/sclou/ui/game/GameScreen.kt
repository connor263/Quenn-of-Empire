package com.samsung.android.sclou.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samsung.android.sclou.ui.game.composables.BackButton
import com.samsung.android.sclou.ui.game.composables.ImageSlot
import com.samsung.android.sclou.ui.game.composables.MenuButton
import com.samsung.android.sclou.ui.navigation.QuennNavKeys
import com.samsung.android.sclou.utils.game.SCORE_TO_WON


@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel = hiltViewModel()) {
    val score = viewModel.score
    val slots = viewModel.slots
    val gameEnd = viewModel.gameEnd

    BackButton(text = "Back") {
        navController.navigate(QuennNavKeys.Menu.route){
            popUpTo(QuennNavKeys.Game.route){inclusive = true}
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 128.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.weight(0.30F),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color.Cyan.copy(alpha = 0.7F)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Score: $score",
                    fontSize = 34.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "To win: $SCORE_TO_WON",
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.35F)
                .background(Color.Blue.copy(alpha = 0.9F))
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(slots.size) {
                Spacer(Modifier.size(2.dp))
                ImageSlot(
                    modifier = Modifier.weight(0.25F),
                    type = slots[it].type
                )
                Spacer(Modifier.size(2.dp))
            }
        }

        Spacer(Modifier.height(64.dp))
        MenuButton(modifier = Modifier.weight(0.35F), text = "PLAY", onClick = {
            viewModel.roll()
        })
    }

    LaunchedEffect(score) {
        if (gameEnd.value) {
            navigateToScore(navController)
        }
    }
}

fun navigateToScore(navController: NavController) {
    navController.navigate("score") {
        popUpTo("score") { inclusive = true }
    }
}


@Preview(showBackground = true)
@Composable
fun GamePagePreview(navController: NavController = rememberNavController()) {
    GameScreen(navController = navController)
}