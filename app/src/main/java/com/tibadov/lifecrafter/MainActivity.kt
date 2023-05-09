package com.tibadov.lifecrafter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.tibadov.lifecrafter.ui.theme.LifeCrafterTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeCrafterTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            Column(modifier = Modifier.fillMaxSize()) {
                                // Add your app's main content here
//                                val count1 = remember { mutableStateOf(20) }
//                                val count2 = remember { mutableStateOf(20) }
//                                Column(modifier = Modifier.fillMaxSize()) {
//                                    LifeCounterWithLog(count = count1, modifier = Modifier
//                                        .fillMaxHeight(0.5f)
//                                        .fillMaxWidth()
//                                        .rotate(180f))
//                                    LifeCounterWithLog(count = count2, modifier = Modifier
//                                        .fillMaxWidth())
//                                }
                                IconButton(onClick = { navController.navigate("settings") }) {
                                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                                }
                            }
                        }
                        composable("settings") {
                            Column(modifier = Modifier.fillMaxSize()) {
                                // Add your app's settings content here
                                TopAppBar(
                                    title = { Text("Settings") },
                                    navigationIcon = {
                                        IconButton(onClick = { navController.popBackStack() }) {
                                            Icon(
                                                Icons.Default.ArrowBack,
                                                contentDescription = "Back"
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
