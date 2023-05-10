package com.tibadov.lifecrafter

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class CounterState {
    var count = mutableStateOf(20)
    val countLog = mutableStateListOf(count.value)
    var lastUpdateTimeMs = 0L
}
