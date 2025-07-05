package com.mahmoudrh.bahgatresturant.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.PopularRestaurant
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.theme.secondaryFontColor

@Composable
fun PopularRestaurantItem(item: PopularRestaurant) {
    val itemRate = item.rate.toString().substring(0, 3)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f),
            painter = painterResource(id = item.coverImage),
            contentDescription = stringResource(item.name),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 4.dp),
            text = stringResource(item.name),
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 16.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 16.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(id = R.drawable.ic_star),
                contentDescription = "rating",
                tint = orange
            )
            Text(
                text = " $itemRate ",
                style = TextStyle(
                    color = orange,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
            Text(
                text = " (${item.rateCount} ratings)  ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )

            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height(3.dp)
                    .clip(CircleShape)
                    .background(orange)
            )
            Text(
                text = "  ${item.foodKind} ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        }

    }
}
