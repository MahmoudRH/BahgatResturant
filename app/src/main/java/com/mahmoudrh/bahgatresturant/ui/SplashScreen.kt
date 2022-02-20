package com.mahmoudrh.bahgatresturant.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToPageView: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navigateToPageView()
    }
    BahgatResturantTheme {
        Box {
            Image(
                painter = painterResource(id = R.drawable.ic_splash_background),
                contentDescription = null,
                Modifier.fillMaxSize()
            )
            Logo(modifier = Modifier.align(Alignment.Center))
        }
    }
}