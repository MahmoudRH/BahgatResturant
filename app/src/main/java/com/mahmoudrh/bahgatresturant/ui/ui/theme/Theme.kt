package com.mahmoudrh.bahgatresturant.ui.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = orange,
)

private val LightColorPalette = lightColors(
    primary = orange,
)

@Composable
fun BahgatResturantTheme(
    content: @Composable () -> Unit
) {

    val colors = LightColorPalette
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}