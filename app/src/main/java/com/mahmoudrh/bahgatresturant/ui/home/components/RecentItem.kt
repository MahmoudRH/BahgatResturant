package com.mahmoudrh.bahgatresturant.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun RecentItem(item: PopularRestaurant) {
    val itemRate = item.rate.toString().substring(0, 3)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp)
    ) {
        Image(
            modifier = Modifier
                .width(110.dp)
                .padding(end = 20.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = item.coverImage),
            contentDescription = stringResource(item.name),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = stringResource(item.name),
                style = TextStyle(
                    color = primaryFontColor,
                    fontSize = 16.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "${item.foodKind} ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
            Spacer(modifier = Modifier.size(4.dp))
            Row {
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
                    text = stringResource(R.string.ratings, item.rateCount),
                    style = TextStyle(
                        color = secondaryFontColor,
                        fontSize = 13.sp,
                        fontFamily = metropolisFontFamily
                    )
                )
            }
        }
    }
}
