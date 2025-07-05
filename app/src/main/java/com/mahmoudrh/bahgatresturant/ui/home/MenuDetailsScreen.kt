package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.Product
import com.mahmoudrh.bahgatresturant.ui.theme.black
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.white
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui_components.SearchField


private val list = arrayOf(
    Product(
        image = R.drawable.restaurant_x,
        name = R.string.french_apple_pie,
        des = R.string.minute_by_tuk_tuk,
        rate = 4.9f,
        type = R.string.desserts
    ), Product(
        image = R.drawable.restaurant_y,
        name = R.string.dark_chocolate_cake,
        des = R.string.cakes_by_tella,
        rate = 4.7f,
        type = R.string.desserts
    ), Product(
        image = R.drawable.restaurent_a,
        name = R.string.french_apple_pie,
        des = R.string.minute_by_tuk_tuk,
        rate = 4.9f,
        type = R.string.desserts
    ), Product(
        image = R.drawable.restaurent_b,
        name = R.string.dark_chocolate_cake,
        des = R.string.cakes_by_tella,
        rate = 4.7f,
        type = R.string.desserts
    )
)

@Composable
fun MenuDetailsScreen() {
    LazyColumn {
        //-> Top Section
        item {
            AppTopBar(title = stringResource(R.string.desserts))
            Spacer(modifier = Modifier.height(20.dp))
            SearchField()
            Spacer(modifier = Modifier.height(20.dp))
        }

        //-> Deserts List
        itemsIndexed(list) { index, item ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(10))
                    .aspectRatio(2f)
            ) {
                Image(
                    painter = painterResource(id = list[index].image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
                BlackShadow()
                SetProductData(
                    modifier = Modifier.align(Alignment.BottomStart), list = list, index = index
                )
            }
            // Spacer between items
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Preview
@Composable
private fun MenuDetailsPrev() {
    Surface { MenuDetailsScreen() }
}

@Composable
private fun BlackShadow() {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        black.copy(alpha = 0f), black.copy(alpha = 0.3f), black.copy(alpha = 0.9f)
                    )
                )
            )
    )
}

@Composable
private fun SetProductData(modifier: Modifier, list: Array<Product>, index: Int) {
    Column(
        modifier = modifier.padding(start = 20.dp, bottom = 20.dp)
    ) {
        Text(
            text = stringResource(list[index].name), style = TextStyle(
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = white
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ic_stare), contentDescription = null
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = list[index].rate.toString(), style = TextStyle(
                    fontFamily = metropolisFontFamily, fontSize = 12.sp, color = orange
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(list[index].des), style = TextStyle(
                    fontFamily = metropolisFontFamily, fontSize = 12.sp, color = white
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = stringResource(list[index].type), style = TextStyle(
                    fontFamily = metropolisFontFamily, fontSize = 12.sp, color = white
                )
            )
        }
    }
}