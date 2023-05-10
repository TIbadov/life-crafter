package com.tibadov.lifecrafter

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, settingsStorage: SettingsStorage) {
    val startingValue = remember { mutableStateOf(settingsStorage.getValue(SettingKeys.STARTING_VALUE) ?: 20) } // default value
    val playerCount = remember { mutableStateOf(settingsStorage.getValue(SettingKeys.NUMBER_OF_PLAYERS) ?: 2) } // number of players

    val playerOptions = remember { listOf(2, 3, 4, 5, 6) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(modifier = Modifier.padding(top = 62.dp, start = 16.dp, end = 16.dp)) {
                OutlinedTextField(
                    value = startingValue.value.toString(),
                    onValueChange = { newString ->
                        val newValue = newString.filter { it.isDigit() }.toIntOrNull()
                        if (newValue != null) {
                            startingValue.value = newValue
                            settingsStorage.setValue(SettingKeys.STARTING_VALUE, newValue)
                        }
                    },
                    label = { Text("Starting Value") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text ="Number of Players: ${playerCount.value}",
                    style = MaterialTheme.typography.titleMedium)

                Slider(
                    value = playerCount.value.toFloat(),
                    onValueChange = { newValueFloat ->
                        val newValue = newValueFloat.roundToInt()
                        playerCount.value = newValue
                        settingsStorage.setValue(SettingKeys.NUMBER_OF_PLAYERS, newValue)
                    },
                    valueRange = playerOptions.first().toFloat()..playerOptions.last().toFloat(),
                    steps = playerOptions.size - 1,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    )
}
