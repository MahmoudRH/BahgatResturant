package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.Product
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

@Composable
fun MenuDetailsScreen() {
    val list = arrayOf(
        Product(
            image = R.drawable.restaurant_x,
            name = "French Apple Pie",
            des = "Minute by tuk tuk",
            rate = 4.9f,
            type = "Desserts"
        ),
        Product(
            image = R.drawable.restaurant_y,
            name = "Dark Chocolate Cake",
            des = "Cakes by Tella",
            rate = 4.7f,
            type = "Desserts"
        ),
        Product(
            image = R.drawable.restaurent_a,
            name = "French Apple Pie",
            des = "Minute by tuk tuk",
            rate = 4.9f,
            type = "Desserts"
        ),
        Product(
            image = R.drawable.restaurent_b,
            name = "Dark Chocolate Cake",
            des = "Cakes by Tella",
            rate = 4.7f,
            type = "Desserts"
        ),
    )
    BahgatResturantTheme() {
        LazyColumn {
            //-> Top Section
            item {
                TopBar(title = "Desserts")
                Spacer(modifier = Modifier.height(20.dp))
                SearchField()
                Spacer(modifier = Modifier.height(20.dp))
            }

            //-> Deserts List
            itemsIndexed(list) { index, item ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .aspectRatio(2f)
                    )
                    {
                        Image(
                            painter = painterResource(id = list[index].image),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                        )
                        BlackShadow()
                        SetProductData(modifier = Modifier.align(Alignment.BottomStart), list = list, index = index)
                    }
                    // Spacer between items
                    Spacer(modifier = Modifier.height(5.dp))

            }
        }
    }
}

@Composable
fun BlackShadow(){
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        black.copy(alpha = 0f),
                        black.copy(alpha = 0.3f),
                        black.copy(alpha = 0.9f)
                    )
                )
            )
    )
}

@Composable
fun SetProductData(modifier: Modifier, list: Array<Product>, index: Int){
    Column(
        modifier = modifier
            .padding(start = 20.dp, bottom = 20.dp)
    ) {
        Text(
            text = list[index].name,
            style = TextStyle(
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = white
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ic_stare),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = list[index].rate.toString(),
                style = TextStyle(
                    fontFamily = metropolisFontFamily,
                    fontSize = 12.sp,
                    color = orange
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = list[index].des,
                style = TextStyle(
                    fontFamily = metropolisFontFamily,
                    fontSize = 12.sp,
                    color = white
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = list[index].type,
                style = TextStyle(
                    fontFamily = metropolisFontFamily,
                    fontSize = 12.sp,
                    color = white
                )
            )
        }
    }
}