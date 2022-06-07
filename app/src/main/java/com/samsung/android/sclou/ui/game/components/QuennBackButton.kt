package com.samsung.android.sclou.ui.game.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuennBackButton(
    modifier: Modifier = Modifier,
    text: String = "Back",
    style: TextStyle = TextStyle(
        fontSize = 24.sp,
        color = Color.Black
    ),
    action: () -> Unit
) {
    TextButton(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 24.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow.copy(alpha = 0.7F)),
        border = BorderStroke(2.dp, Color.White),
        onClick = { action() }) {
        Text(
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 2.dp),
            text = text,
            style = style
        )
    }
}

