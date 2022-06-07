package com.samsung.android.sclou.ui.game.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.samsung.android.sclou.R
import com.samsung.android.sclou.utils.game.SLOT_BOARD_COLUMNS
import com.samsung.android.sclou.utils.game.SLOT_BOARD_ROWS

@Composable
fun QuennSlotBoard(stepX: Dp, stepY: Dp) {
    Box(
        modifier = Modifier
            .size(stepX * SLOT_BOARD_COLUMNS, stepY * SLOT_BOARD_ROWS),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.game_board),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row {
            repeat(5) {
                QuennSlotView(columnId = it + 1, stepX = stepX, stepY = stepY)
            }
        }
    }

}