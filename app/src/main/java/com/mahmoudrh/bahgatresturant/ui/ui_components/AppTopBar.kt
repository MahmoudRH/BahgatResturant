package com.mahmoudrh.bahgatresturant.ui.ui_components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.theme.white

@Composable
fun AppTopBar(backIcon: Boolean = false, title: String, action: Boolean = true) {

    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor
                )
            )
        },
        actions = {
            if (action) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = com.mahmoudrh.bahgatresturant.R.drawable.ic_cart),
                        contentDescription = "",
                        tint = primaryFontColor
                    )
                }
            }
        },
        backgroundColor = white,
        elevation = 0.dp,
        navigationIcon = if (backIcon) {
            {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = com.mahmoudrh.bahgatresturant.R.drawable.ic_back),
                        contentDescription = "",
                        tint = primaryFontColor
                    )
                }
            }
        } else null
    )
}
