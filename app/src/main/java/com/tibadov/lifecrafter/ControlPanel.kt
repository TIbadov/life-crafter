package com.tibadov.lifecrafter

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ControlPanel(navController: NavController, reset: () -> Unit, onResetTap: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            reset()
                        },
                        onTap = {
                            onResetTap()
                        }
                    )
                }
        ) {
            Icon(Icons.Default.Refresh, contentDescription = "Reset", modifier = Modifier
                .size(36.dp)
                .align(Alignment.Center))
        }
        IconButton(
            onClick = { navController.navigate(NavigationTarget.Settings.route) },
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
        ) {
            Icon(Icons.Default.Settings, contentDescription = "Settings", modifier = Modifier.size(36.dp))
        }
    }
}
