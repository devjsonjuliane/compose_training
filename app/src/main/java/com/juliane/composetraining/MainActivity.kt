package com.juliane.composetraining

import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(rememberScaffoldState(), rememberCoroutineScope(), LocalConfiguration.current)
        }
    }
}

@Composable
fun HomeScreen(scaffoldState: ScaffoldState, scope: CoroutineScope, current: Configuration) {
    when (current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Column(
                Modifier
                    .background(Color.Black)
                    .fillMaxSize()
            ) {
            }
        }
        else -> {
            Scaffold(
                scaffoldState = scaffoldState,
                drawerContent = {
                    DrawerPanel(
                        scaffoldState = scaffoldState,
                        scope = scope
                    )
                },
                topBar = {
                    TopBar(scaffoldState, scope)
                }) { padding ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .verticalScroll(rememberScrollState())
                        .padding(padding)
                ) {
                    UpperPanel()
                    LowerPanel()
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen(rememberScaffoldState(), rememberCoroutineScope(), LocalConfiguration.current)
}