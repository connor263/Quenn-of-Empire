package com.samsung.android.sclou.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.samsung.android.sclou.MainViewModel

@Composable
fun InitScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    var isLoading by remember { mutableStateOf(true) }

    Surface(Modifier.fillMaxSize(), color = Color.Black) {
        if (isLoading) {
            CircularProgressIndicator(Modifier.fillMaxSize().size(120.dp), color = Color.White)
        } else {
            AlertDialog(
                modifier = Modifier.padding(4.dp),
                shape = RoundedCornerShape(16.dp),
                title = {
                    Text(
                        "No internet connection",
                        style = MaterialTheme.typography.h4
                    )
                },
                text = {
                    Text(
                        "Check your internet connection and try again later",
                        style = MaterialTheme.typography.body2
                    )
                },
                onDismissRequest = { viewModel.sendIifwesbxwxuzmyspEvent() },
                confirmButton = {
                    TextButton(onClick = { viewModel.sendIifwesbxwxuzmyspEvent() }) {
                        Text("Try again", style = MaterialTheme.typography.button)
                    }
                })
        }
    }

    LaunchedEffect(viewModel.isifwesbxwxuzmysng) {
        isLoading = viewModel.isifwesbxwxuzmysng
    }
}