package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ButtonWithImage
import com.mahmoudrh.bahgatresturant.ui.FilledButton
import com.mahmoudrh.bahgatresturant.ui.IconButton
import com.mahmoudrh.bahgatresturant.ui.TopBar
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

@Composable
fun ProductDetailsScreen() {
    val scrollState = rememberScrollState()
    val sizeList = mutableListOf<String>("10", "15", "20")
    val ingredientsList = mutableListOf<String>("Samer", "Mahmoud", "Khaled")

    BahgatResturantTheme() {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.restaurent_b),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(360.dp),
                contentScale = ContentScale.Crop,
            )
            BlackShadow2()
            TopBar(iconColor = white)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.65f)
                    .background(white, shape = RoundedCornerShape(topStart = 42.dp, topEnd = 42.dp))
                    .align(Alignment.BottomCenter)
            ) {
                Column(modifier = Modifier.verticalScroll(state = scrollState)) {
                    Text(
                        "Tandoori Chicken Pizza",
                        modifier = Modifier.padding(top = 29.dp, start = 20.dp),
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = metropolisFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = primaryFontColor
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                        Column() {
                            //Rating bar
                            Text(
                                text = "4 Star Ratings",
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontFamily = metropolisFontFamily,
                                    color = orange
                                )
                            )
                        }
                        Spacer(modifier = Modifier.fillMaxWidth(0.55f))
                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                "RS. 750",
                                style = TextStyle(
                                    fontSize = 31.sp,
                                    fontFamily = metropolisFontFamily,
                                    color = primaryFontColor,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                "/ per Portion",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = cabinFontFamily,
                                    color = secondaryFontColor
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Description",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = metropolisFontFamily,
                            color = primaryFontColor,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ornare leo non mollis id cursus. Eu euismod faucibus in leo malesuada",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = metropolisFontFamily,
                            color = secondaryFontColor
                        )
                    )
                    Spacer(modifier = Modifier.height(17.dp))
                    Divider(modifier = Modifier.padding(horizontal = 20.dp))
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Customize your Order",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = metropolisFontFamily,
                            color = primaryFontColor,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Dropdown(sizeList, "- Select the size of portion -")
                    Spacer(modifier = Modifier.height(15.dp))
                    Dropdown(ingredientsList, "- Select the ingredients -")
                    Spacer(modifier = Modifier.height(24.dp))
                    NumberOfItem()
                    Spacer(modifier = Modifier.height(27.dp))
                    TotalPrice()
                }
            }
            Box(modifier = Modifier.align(Alignment.TopEnd).padding(end = 30.dp)) {
                Column() {
                    Spacer(modifier = Modifier.fillMaxHeight(0.315f))
                    IconButton(image = R.drawable.ic_favorite){}
                }
            }
        }
    }
}

@Composable
fun Dropdown(list: List<String>, default: String) {
    var value: String by remember { mutableStateOf(default) }
    var expanded by remember { mutableStateOf(false)}

    Box(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .background(color = gray, shape = RoundedCornerShape(5.dp))) {
        Row(
            Modifier
                .padding(15.dp)
                .clickable {
                    expanded = !expanded
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = value, style = TextStyle(fontSize = 15.sp, color = primaryFontColor, fontFamily = metropolisFontFamily) ) // Country name label
            Spacer(modifier = Modifier.fillMaxWidth(0.9f))
            Image(painter = painterResource(id = R.drawable.ic_dropdown), contentDescription = "")

            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }) {
                list.forEach{ valuee->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        value = valuee
                    }) {
                        Text(text = valuee, style = TextStyle(fontSize = 15.sp, color = primaryFontColor, fontFamily = metropolisFontFamily))
                    }
                }
            }

        }
    }
}

@Composable
fun BlackShadow2(){
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        black.copy(alpha = 0.3f),
                        black.copy(alpha = 0f),
                    )
                )
            )
    )
}

@Composable
fun TotalPrice(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
                .width(95.dp)
                .background(
                    color = orange,
                    shape = RoundedCornerShape(topEnd = 38.dp, bottomEnd = 38.dp)
                )
        ) {}

        Box(
            modifier = Modifier
                .align(Alignment.Center)
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
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 55.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Total Price", style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = metropolisFontFamily,
                        color = primaryFontColor,
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "LKR 1500", style = TextStyle(
                    fontSize = 21.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor,
                    fontWeight = FontWeight.Bold
                ))
                Spacer(modifier = Modifier.height(10.dp))
                ButtonWithImage(
                    text = "Add to Cart",
                    image = R.drawable.ic_buy,
                    color = orange,
                    modifier = Modifier
                        .height(40.dp)
                        .width(200.dp)
                ) {}
            }
        }

        IconButton(image = R.drawable.ic_cart, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 20.dp)){}
    }
}

@Composable
fun NumberOfItem(){
    Row(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Number of Portions",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = metropolisFontFamily,
                color = primaryFontColor,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.width(50.dp))
        FilledButton(
            text = "+", modifier = Modifier
                .width(50.dp)
                .height(30.dp)
        ) {}
        Spacer(modifier = Modifier.width(7.dp))
        Box(
            modifier = Modifier
                .width(47.dp)
                .height(30.dp)
                .border(
                    width = 1.dp,
                    color = orange,
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "2",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = cabinFontFamily,
                    color = orange,
                )
            )
        }
        Spacer(modifier = Modifier.width(7.dp))
        FilledButton(
            text = "-", modifier = Modifier
                .width(50.dp)
                .height(30.dp)
        ) {}
    }
}