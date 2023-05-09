package com.tibadov.lifecrafter

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    val count1 = remember { mutableStateOf(20) }
    val count2 = remember { mutableStateOf(20) }
    val showSnackbar = remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(Modifier.weight(1f)) {
                LifeCounterWithLog(
                    count = count1, modifier = Modifier
                        .rotate(180f)
                )
            }
            ControlPanel(
                navController = navController,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onResetTap = {
                    showSnackbar.value = true
            })
            Box(Modifier.weight(1f)) {
                LifeCounterWithLog(
                    count = count2, modifier = Modifier
                )
            }
        }

        SnackbarHost(
            modifier = Modifier.align(Alignment.TopCenter),
            hostState = snackbarHostState
        )
    }

    LaunchedEffect(showSnackbar.value) {
        if (showSnackbar.value) {
            snackbarHostState.showSnackbar("Long press to reset")
            showSnackbar.value = false
        }
    }
}
