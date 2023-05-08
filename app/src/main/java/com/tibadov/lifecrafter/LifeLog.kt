package com.tibadov.lifecrafter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LifeLog(count: MutableState<Int>, modifier: Modifier = Modifier) {
    val logUpdateDelayMs = 3000L
    val items = remember { mutableStateListOf(count.value) }
    val textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
    val lazyListState = rememberLazyListState()
    val labelOffset = 24.dp
    val lastUpdateTimeMs = remember { mutableStateOf(0L) }

    LaunchedEffect(key1 = count.value) {
        if (count.value == items.lastOrNull()) {
            return@LaunchedEffect
        }

        val currentTimeMs = System.currentTimeMillis()
        if (currentTimeMs - lastUpdateTimeMs.value > logUpdateDelayMs) {
            items.add(count.value)
            lazyListState.animateScrollToItem(items.size - 1)
        } else {
            require(items.size > 0) { "Size here should always be greater than 0" }
            items[items.size - 1] = count.value
        }
        lastUpdateTimeMs.value = currentTimeMs
    }

    Row(modifier = modifier) {
        Text(text = "Log:", style = textStyle, modifier = Modifier.padding(start = labelOffset))

        LazyColumn(
            modifier = Modifier.weight(1f),
            state = lazyListState
        ) {
            items.forEachIndexed { _, item ->
                item {
                    Box(modifier = Modifier.fillParentMaxWidth()) {
                        Text(
                            text = item.toString(),
                            style = textStyle,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}
