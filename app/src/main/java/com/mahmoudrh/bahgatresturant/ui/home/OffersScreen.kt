package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.home.components.PopularRestaurantItem
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.secondaryFontColor

@Composable
fun OffersScreen(){
    BahgatResturantTheme() {
        Column() {
            AppTopBar(title = stringResource(R.string.latest_offers), backIcon = false)
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = stringResource(R.string.find_discounts_offers_special_meals_and_more),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily,
                    color = secondaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(17.dp))
            FilledButton(text = stringResource(R.string.check_offers), modifier = Modifier
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

@Preview
@Composable
private fun OffersPrev() {
    Surface { OffersScreen() }
}