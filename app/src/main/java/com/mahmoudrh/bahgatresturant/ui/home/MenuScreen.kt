package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.Menu
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.IconButton
import com.mahmoudrh.bahgatresturant.ui.ui_components.SearchField
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.white

@Composable
fun MenuScreen() {
    val list = arrayOf(
        Menu(image = R.drawable.item_a, name = "Food", numOfItem = 120),
        Menu(image = R.drawable.item_b, name = "Beverages", numOfItem = 250),
        Menu(image = R.drawable.item_b, name = "Testtt", numOfItem = 920),
        Menu(image = R.drawable.item_c, name = "Desserts", numOfItem = 520),
    )

    BahgatResturantTheme() {
        Column() {
            AppTopBar(backIcon = false, title = "Menu")
            Spacer(modifier = Modifier.height(20.dp))
            SearchField()
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn {
                itemsIndexed(list) { index, item ->
                    MenuItem(index, list)
                }
            }
        }

    }
}

@Composable
fun MenuItem(index: Int, list: Array<Menu>) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OrangeBox(index, list)
        WhiteBox(index, list, Modifier.align(Alignment.CenterEnd))
        IconButton(
            image = R.drawable.ic_forward, modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 23.dp)
                .width(40.dp)
                .height(40.dp)
        ) {}
        CircleImage(
            image = list[index].image, modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)
        )
    }
}

@Composable
fun CircleImage(modifier: Modifier = Modifier, image: Int) {
    Box(
        modifier = modifier
            .height(70.dp)
            .width(70.dp)
            .background(white, shape = RoundedCornerShape(200.dp)),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun OrangeBox(index: Int, list: Array<Menu>) {
    var roundTob = 0
    var roundBottom = 0
    if (index == 0) {
        roundTob = 38
    }
    if (index == list.size - 1) {
        roundBottom = 38
    }
    Box(
        modifier = Modifier
            .height(130.dp)
            .width(95.dp)
            .background(
                color = orange,
                shape = RoundedCornerShape(
                    topEnd = roundTob.dp,
                    bottomEnd = roundBottom.dp
                )
            )
    ) {}
}

@Composable
fun WhiteBox(index: Int, list: Array<Menu>, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.85f)
            .padding(end = 40.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    bottomStart = 40.dp,
                    topEnd = 10.dp,
                    bottomEnd = 10.dp
                )
            )
            .background(color = white)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 50.dp, top = 20.dp, bottom = 20.dp, end = 35.dp)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = list[index].name, style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "${list[index].numOfItem} Items", style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor,
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}