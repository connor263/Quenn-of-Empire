package com.samsung.android.sclou.ui.game.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BackButton(text: String, onClick: () -> Unit = {}) {
    TextButton(
        modifier = Modifier
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue.copy(alpha = 0.8F)),
        shape = RoundedCornerShape(24.dp),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = text,
            style = MaterialTheme.typography.button.copy(fontSize =24.sp, color = Color.White)
        )
    }
}