package com.tibadov.lifecrafter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        val count1 = remember { mutableStateOf(20) }
        val count2 = remember { mutableStateOf(20) }
        LifeCounterWithLog(
            count = count1, modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .rotate(180f)
        )
        ControlPanel(navController = navController, modifier = Modifier)
        LifeCounterWithLog(
            count = count2, modifier = Modifier
                .fillMaxWidth()
        )
    }
}