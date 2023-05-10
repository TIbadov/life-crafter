package com.tibadov.lifecrafter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class CounterState() {
    var count: MutableState<Int> = mutableStateOf(0)
    var countLog: MutableList<Int> = mutableStateListOf()
    var lastUpdateTimeMs: Long = 0L

    fun reset(startingValue: Int) {
        count.value = startingValue
        countLog.clear()
        countLog.add(count.value)
        lastUpdateTimeMs = 0
    }
}
