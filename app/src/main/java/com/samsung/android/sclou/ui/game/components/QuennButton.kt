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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuennButton(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = TextStyle(
        fontSize = 32.sp,
        color = Color.Black
    ),
    action: () -> Unit
) {
    TextButton(
        modifier = modifier,
        shape = RoundedCornerShape(32.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 32.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow.copy(alpha = 0.8F)),
        border = BorderStroke(2.dp, Color.White),
        onClick = { action() }) {
        Text(
            modifier = Modifier.padding(horizontal = 64.dp, vertical = 8.dp),
            text = text,
            style = style
        )
    }
}


@Preview
@Composable
fun QuennButtonPreview(
    modifier: Modifier = Modifier,
    text: String = "",
    style: TextStyle = TextStyle()
) {
    QuennButton(text = "Play") {}
}