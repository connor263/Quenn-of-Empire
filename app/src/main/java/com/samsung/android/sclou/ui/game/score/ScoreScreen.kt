package com.samsung.android.sclou.ui.game.score

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samsung.android.sclou.ui.game.composables.MenuButton
import com.samsung.android.sclou.ui.navigation.QuennNavKeys

@Composable
fun ScoreScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(top = 64.dp)
                .weight(0.25F),
            backgroundColor = Color.Cyan.copy(alpha = 0.7F),
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(
                modifier = Modifier.padding(64.dp),
                text = "You WIN!",
                textAlign = TextAlign.Center,
                color = Color.White,
                style = MaterialTheme.typography.h4
            )
        }
        Spacer(Modifier.height(128.dp))

        MenuButton(modifier = Modifier.weight(0.15F), text = "Play again?") {
            navController.navigate(QuennNavKeys.Game.route) {
                popUpTo(QuennNavKeys.Score.route) { inclusive = true }
            }
        }

        Spacer(Modifier.height(8.dp))

        MenuButton(
            modifier = Modifier.weight(0.15F),
            text = "Menu"
        ) {
            navController.navigate(QuennNavKeys.Menu.route) {
                popUpTo(QuennNavKeys.Score.route) { inclusive = true }
            }
        }
    }
}