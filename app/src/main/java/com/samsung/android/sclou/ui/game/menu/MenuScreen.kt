package com.samsung.android.sclou.ui.game.menu

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samsung.android.sclou.MainActivity
import com.samsung.android.sclou.ui.game.composables.MenuButton

@Composable
fun MenuScreen(navController: NavController = rememberNavController()) {
    val activity = (LocalContext.current as? MainActivity)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MenuButton(
            text = "Start",
            onClick = { navController.navigate("game") }
        )
        Spacer(Modifier.size(32.dp))
        MenuButton(
            text = "Exit",
            onClick = { activity?.finish() }
        )
    }
}


