package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.MealKind
import com.mahmoudrh.bahgatresturant.model.PopularRestaurant
import com.mahmoudrh.bahgatresturant.ui.home.components.MealKinds
import com.mahmoudrh.bahgatresturant.ui.home.components.MostPopular
import com.mahmoudrh.bahgatresturant.ui.home.components.PopularRestaurantItem
import com.mahmoudrh.bahgatresturant.ui.home.components.RecentItem
import com.mahmoudrh.bahgatresturant.ui.home.components.SectionHeader
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui_components.SearchField

val testList = listOf(
    MealKind(R.string.offers, R.drawable.offers),
    MealKind(R.string.sri_lankan, R.drawable.sri_lankan),
    MealKind(R.string.italian, R.drawable.italian),
    MealKind(R.string.indian, R.drawable.indian)
)
val testList2 = listOf(
    PopularRestaurant(
        name = R.string.minute_by_tuk_tuk,
        rate = 4.9f,
        rateCount = 124,
        foodKind = R.string.western_food,
        coverImage = R.drawable.restaurent_a
    ),
    PopularRestaurant(
        name = R.string.cafe_de_noir,
        rate = 4.8f,
        rateCount = 137,
        foodKind = R.string.italian_food,
        coverImage = R.drawable.restaurent_b
    ),
    PopularRestaurant(
        name = R.string.bakes_by_tella,
        rate = 4.7f,
        rateCount = 125,
        foodKind = R.string.french_food,
        coverImage = R.drawable.restaurent_c
    )
)
val testList3 = listOf(
    PopularRestaurant(
        name = R.string.cafe_de_bambaa,
        rate = 4.9f,
        rateCount = 124,
        foodKind = R.string.western_food,
        coverImage = R.drawable.restaurant_x
    ),
    PopularRestaurant(
        name = R.string.burger_by_bella,
        rate = 4.8f,
        rateCount = 137,
        foodKind = R.string.western_food,
        coverImage = R.drawable.restaurant_y
    )
)
val testList4 = listOf(
    PopularRestaurant(
        name = R.string.mulberry_pizza_by_josh,
        rate = 4.9f,
        rateCount = 124,
        foodKind = R.string.western_food,
        coverImage = R.drawable.item_a
    ),
    PopularRestaurant(
        name = R.string.barita,
        rate = 4.8f,
        rateCount = 137,
        foodKind = R.string.italian_food,
        coverImage = R.drawable.item_b
    ),
    PopularRestaurant(
        name = R.string.pizza_rush_hour,
        rate = 4.7f,
        rateCount = 125,
        foodKind = R.string.french_food,
        coverImage = R.drawable.item_c
    )
)

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        //--> Top Section
        item {
            TopBar(stringResource(R.string.mahmoud))
            SearchField()
            Spacer(modifier = Modifier.size(18.dp))
            MealKinds(testList)
            Spacer(modifier = Modifier.size(25.dp))
        }

        //--> PopularRestaurants Section
        item {
            SectionHeader(sectionName = stringResource(R.string.popular_restaurants)) {}
            Spacer(modifier = Modifier.size(8.dp))
        }
        items(testList2) { item ->
            PopularRestaurantItem(item)
        }

        //--> MostPopular Section
        item {
            SectionHeader(sectionName = stringResource(R.string.most_popular)) {}
            Spacer(modifier = Modifier.size(8.dp))
            MostPopular(list = testList3)
        }

        //--> ResentItems Section
        item {
            SectionHeader(sectionName = stringResource(R.string.recent_items)) {}
            Spacer(modifier = Modifier.size(8.dp))
        }
        items(testList4) { item ->
            RecentItem(item)
        }
    }
}

@Composable
private fun TopBar(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.hello, userName),
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 20.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_cart),
            contentDescription = null,
            tint = primaryFontColor
        )
    }
}

@Preview
@Composable
private fun HomePrev() {
    Surface {
        HomeScreen()
    }
}