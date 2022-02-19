package com.mahmoudrh.bahgatresturant.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mahmoudrh.bahgatresturant.MyNavHost
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BahgatResturantTheme {
            val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyNavHost(navHostController = navController)
                }
            }
        }
    }
}