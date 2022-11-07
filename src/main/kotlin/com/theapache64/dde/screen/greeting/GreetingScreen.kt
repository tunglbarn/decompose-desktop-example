package com.theapache64.dde.screen.greeting

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theapache64.dde.screen.dialog.DialogHolder

@Composable
fun GreetingScreen(
    greeting: String,
    onGoBackClicked: () -> Unit,
    onResizeClicked: () -> Unit,
    onNormalSizeClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Greeting
        Text(
            text = greeting,
            fontSize = 40.sp
        )

        // Spacing between text and button
        Spacer(modifier = Modifier.height(30.dp))

        // Go back button
        Button(onClick = onGoBackClicked) {
            Text(text = "GO BACK!")
        }

        Spacer(modifier = Modifier.height(30.dp))

        var isDialogOpen by remember { mutableStateOf(false) }

        DialogHolder(isDialogOpen) {v -> isDialogOpen = v}

        Spacer(modifier = Modifier.height(30.dp))

        var isExpanded by  remember { mutableStateOf(false) }

        if (!isExpanded) {
            Button(
            onClick = {
                onResizeClicked()
                isExpanded = true
            }
            ) {
                Text(text = "Resize")
            }
        } else {
            Button(
                onClick = {
                    onNormalSizeClicked()
                    isExpanded = false
                }
            ) {
                Text(text = "Resize")
            }
        }
    }
}