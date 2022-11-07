package com.theapache64.dde.screen.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun DialogHolder(isDialogOpen: Boolean, updateDialog: (Boolean) -> Unit) {
    Button(onClick = { updateDialog(true) }) {
        Text("About Dialog")
    }

    if (isDialogOpen) {
        Dialog(
            onCloseRequest = { updateDialog(false) },
            resizable = false
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { updateDialog(false) }
                ) {
                    Text("Close")
                }
            }
        }
    }
}