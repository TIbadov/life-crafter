package com.tibadov.lifecrafter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun LifeCounterWithLog(count: MutableState<Int>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        LifeCounter(count = count, modifier = Modifier.fillMaxHeight(0.6f))
        LifeLog(count = count,modifier = Modifier.fillMaxSize())
    }
}