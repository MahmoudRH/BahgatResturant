package com.mahmoudrh.bahgatresturant.ui.ui_components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.white

@Composable
fun IconButton(modifier: Modifier = Modifier, image: Int, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .height(50.dp)
            .width(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = white),
        shape = RoundedCornerShape(100.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
        )
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "",
            tint = orange
        )
    }
}