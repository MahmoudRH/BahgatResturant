package com.mahmoudrh.bahgatresturant.ui.weclome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui_components.Logo
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToPageView: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(500)
        navigateToPageView()
    }
    Box {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_background),
            contentDescription = null,
            Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Logo(modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
private fun SplashPrev() {
    Surface() { SplashScreen { } }
}