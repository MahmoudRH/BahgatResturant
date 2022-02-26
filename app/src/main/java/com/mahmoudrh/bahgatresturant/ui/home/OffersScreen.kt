package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

@Composable
fun OffersScreen(){
    BahgatResturantTheme() {
        Column() {
            TopBar(title = "Latest Offers", backIcon = false)
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "Find discounts, \nOffers special meals and more!",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily,
                    color = secondaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(17.dp))
            FilledButton(text = "Check Offers", modifier = Modifier
                .height(35.dp)
                .width(160.dp)
                .padding(horizontal = 20.dp),
                fontSize = 12) {}
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(testList2) { item ->
                    PopularRestaurantItem(item)
                }
            }
        }
    }
}