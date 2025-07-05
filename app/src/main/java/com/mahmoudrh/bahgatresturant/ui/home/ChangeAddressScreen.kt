package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.runtime.Composable
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme

@Composable
fun ChangeAddressScreen(){
    BahgatResturantTheme() {
        AppTopBar(title = "Change Address", backIcon = true)
    }
}