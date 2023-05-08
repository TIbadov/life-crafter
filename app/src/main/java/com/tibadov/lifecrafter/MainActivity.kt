package com.tibadov.lifecrafter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.tibadov.lifecrafter.ui.theme.LifeCrafterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeCrafterTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val count1 = remember { mutableStateOf(20) }
                    val count2 = remember { mutableStateOf(20) }
                    Column(modifier = Modifier.fillMaxSize()) {
                        LifeCounter(count = count1, modifier = Modifier
                            .fillMaxHeight(0.5f)
                            .fillMaxWidth()
                            .rotate(180f))
                        LifeCounter(count = count2, modifier = Modifier
                            .fillMaxWidth())
                    }
                }
            }
        }
    }
}
