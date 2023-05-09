package com.tibadov.lifecrafter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ControlPanel(navController: NavController, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(color = Color(0x55FF0000))
    ) {
        IconButton(onClick = { println("^^^ Reset!") }) {
            Icon(Icons.Default.Refresh, contentDescription = "Settings")
        }
        IconButton(onClick = { navController.navigate(NavigationTarget.Settings.route) }) {
            Icon(Icons.Default.Settings, contentDescription = "Settings")
        }
    }
}