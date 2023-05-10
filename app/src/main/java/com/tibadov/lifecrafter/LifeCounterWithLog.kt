package com.tibadov.lifecrafter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun LifeCounterWithLog(counterState: CounterState, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        LifeCounter(counterState = counterState, modifier = Modifier.fillMaxHeight(0.6f))
        LifeLog(counterState = counterState,modifier = Modifier.fillMaxSize())
    }
}