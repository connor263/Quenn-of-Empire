package com.samsung.android.sclou.ui.game.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.samsung.android.sclou.R
import com.samsung.android.sclou.utils.game.enums.SlotType


@Composable
fun ImageSlot(modifier: Modifier = Modifier, type: SlotType) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(
                id = when (type) {
                    SlotType.FIRST -> R.drawable.decal_1
                    SlotType.SECOND -> R.drawable.decal_2
                    SlotType.THIRD -> R.drawable.decal_3
                    SlotType.FOURTH -> R.drawable.decal_4
                }
            ),
            contentDescription = null
        )
    }
}
