package com.tibadov.lifecrafter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LifeCounter(count: MutableState<Int>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = count.value.toString(),
            style = TextStyle(fontSize = 144.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.Center)
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CounterButton(isLeft = true, count = count)
            CounterButton(isLeft = false, count = count)
        }
    }
}

@Composable
private fun CounterButton(
    isLeft: Boolean,
    count: MutableState<Int>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(if (isLeft) 0.5f else 1.0f)
            .fillMaxHeight()
            .clickable { if (isLeft) count.value-- else count.value++ }
    ) {
        var buttonOffset = 24.dp
        Text(
            text = if (isLeft) "-" else "+",
            style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(if (isLeft) Alignment.CenterStart else Alignment.CenterEnd)
                .padding(
                    start = if (isLeft) buttonOffset else 0.dp,
                    end = if (!isLeft) buttonOffset else 0.dp,
                )
        )
    }
}
