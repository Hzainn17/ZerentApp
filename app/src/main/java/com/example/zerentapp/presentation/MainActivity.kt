package com.example.zerentapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import coil.Coil
import coil.ImageLoader
import coil.util.DebugLogger
import com.example.zerentapp.presentation.ZerentApp

import com.example.zerentapp.ui.theme.ZerentAppTheme
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)
        Coil.setImageLoader(
            ImageLoader.Builder(this)
                .logger(DebugLogger(Log.VERBOSE))
                .build()
        )
        installSplashScreen()
        setContent {
            ZerentAppTheme {
                    ZerentApp()

                }
            }
        }
    }

