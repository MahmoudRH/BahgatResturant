package com.mahmoudrh.bahgatresturant.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mahmoudrh.bahgatresturant.MyNavHost
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class,
        androidx.compose.material.ExperimentalMaterialApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BahgatResturantTheme {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(color = Color.White, darkIcons = true)

            val navController = rememberAnimatedNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyNavHost(navHostController = navController)
                }
            }
        }
    }
}