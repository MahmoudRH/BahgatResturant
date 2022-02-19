package com.mahmoudrh.bahgatresturant.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navigateToWelcome: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        navigateToWelcome()
    }
    SplashScreen(alpha = alphaAnim.value)
}

@Composable
fun SplashScreen(alpha: Float) {
    BahgatResturantTheme {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.splash_background),
                contentDescription = null,
                Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null)
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = orange,
                            )
                        ) {
                            append("Bahgat ")
                        }
                        append("Restaurant")
                    },
                    style = TextStyle(
                        color = primaryFontColor,
                        fontFamily = cabinFontFamily,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top = 13.dp)
                )
                Text(
                    text = "FOOD DELIVERY", style = TextStyle(
                        color = primaryFontColor,
                        fontFamily = metropolisFontFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}