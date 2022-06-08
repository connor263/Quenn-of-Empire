package com.samsung.android.sclou.ui.game.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.samsung.android.sclou.R
import com.samsung.android.sclou.data.model.game.QuennSlotModel
import com.samsung.android.sclou.ui.game.slot.SlotViewModel
import com.samsung.android.sclou.utils.game.SLOT_BOARD_ROWS
import com.samsung.android.sclou.utils.game.SLOT_VIEW_ANIM_DURATION
import com.samsung.android.sclou.utils.game.SLOT_VIEW_ROLL_COUNT
import kotlinx.coroutines.launch

@Composable
fun QuennSlotView(
    modifier: Modifier = Modifier,
    viewModel: SlotViewModel = hiltViewModel(),
    columnId: Int,
    stepX: Dp,
    stepY: Dp
) {
    val slotAnim = remember { Animatable(0F) }

    var pos1 by remember { mutableStateOf(QuennSlotModel(column = columnId, row = 1)) }
    var pos2 by remember { mutableStateOf(QuennSlotModel(column = columnId, row = 2)) }
    var pos3 by remember { mutableStateOf(QuennSlotModel(column = columnId, row = 3)) }
    var pos4 by remember { mutableStateOf(QuennSlotModel(column = columnId, row = 4)) }
    var posNext by remember { mutableStateOf(QuennSlotModel(column = columnId, row = 5)) }

    Box(
        modifier = modifier
            .size(stepX, stepY * SLOT_BOARD_ROWS).padding(vertical = 28.dp).padding(bottom = 4.dp)
            .clipToBounds()
    ) {

        Box {
            val listOfSlots = listOf(pos1, pos2, pos3, pos4, posNext)

            if (listOfSlots.any { it.isMatched }) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.game_board_column),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
            listOfSlots.forEachIndexed { index, slot ->
                Image(
                    modifier = Modifier
                        .offset(y = stepY * (index) - slotAnim.value.dp)
                        .size(stepX, stepY)
                        .background(
                            if (slot.isMatched) {
                                Color.Yellow.copy(alpha = 0.7F)
                            } else {
                                Color.Transparent
                            }
                        ),
                    painter = painterResource(id = slot.drawableRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                )
            }
        }

    }


    LaunchedEffect(viewModel.isRoll) {
        launch {
            if (viewModel.isRoll) {
                repeat(SLOT_VIEW_ROLL_COUNT) {
                    slotAnim.animateTo(
                        targetValue = stepY.value,
                        animationSpec = tween(SLOT_VIEW_ANIM_DURATION)
                    )

                    pos1 = pos2
                    pos2 = pos3
                    pos3 = pos4
                    pos4 = posNext

                    pos1.apply {
                        isMatched = false
                        column = columnId
                        row = 1
                    }
                    pos2.apply {
                        isMatched = false
                        column = columnId
                        row = 2
                    }
                    pos3.apply {
                        isMatched = false
                        column = columnId
                        row = 3
                    }
                    pos4.apply {
                        isMatched = false
                        column = columnId
                        row = 4
                    }

                    posNext = QuennSlotModel()
                    slotAnim.animateTo(
                        targetValue = 0F,
                        animationSpec = if (it == SLOT_VIEW_ROLL_COUNT - 1) {
                            spring(dampingRatio = 0.50F)
                        } else snap()
                    )
                }


                viewModel.saveSlots(
                    columnId, listOf(
                        pos1, pos2, pos3, pos4
                    )
                )
            }
        }
    }
}