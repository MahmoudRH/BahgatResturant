package com.mahmoudrh.bahgatresturant.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.placeholderColor

private enum class HomeScrees {
    MENU,
    OFFERS,
    HOME,
    PROFILE,
    MORE
}

@Composable
fun HomeNavigation() {
    val selectedItem = remember { mutableStateOf(HomeScrees.HOME) }

    Box(modifier = Modifier.fillMaxSize()) {
        //-> Main Container ~90% of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.93f)
        ) {
            when (selectedItem.value) {
                HomeScrees.MENU -> MenuScreen()
                HomeScrees.OFFERS -> OffersScreen()
                HomeScrees.HOME -> HomeScreen()
                HomeScrees.PROFILE -> ProfileScreen()
                HomeScrees.MORE -> MoreScreen()
            }
        }

        //-> Bottom Bar ~10% of the screen
        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.12f)
                .align(Alignment.BottomCenter),
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.size(70.dp),
                    backgroundColor = if (selectedItem.value == HomeScrees.HOME) orange else placeholderColor,
                    onClick = {
                        selectedItem.value = HomeScrees.HOME
                    },
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 8.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "menu",
                        tint = Color.White
                    )
                }
            },
            backgroundColor = Color.Transparent,
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.592f),
                    cutoutShape = RoundedCornerShape(50),
                    backgroundColor = Color.White,
                    elevation = 20.dp,
                    contentPadding = PaddingValues(all = 5.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BottomNavigationItem(selected = selectedItem.value == HomeScrees.MENU,
                            onClick = {
                                selectedItem.value = HomeScrees.MENU
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_menu),
                                    contentDescription = "menu",
                                    tint = if (selectedItem.value == HomeScrees.MENU) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "Menu",
                                    style = itemTextStyle(selectedItem.value == HomeScrees.MENU)
                                )
                            })

                        BottomNavigationItem(selected = selectedItem.value == HomeScrees.OFFERS,
                            onClick = {
                                selectedItem.value = HomeScrees.OFFERS
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_shopping_bag),
                                    contentDescription = "offers",
                                    tint = if (selectedItem.value == HomeScrees.OFFERS) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "Offers",
                                    style = itemTextStyle(selectedItem.value == HomeScrees.OFFERS)
                                )
                            })

                        BottomNavigationItem(selected = selectedItem.value == HomeScrees.PROFILE,
                            onClick = {
                                selectedItem.value = HomeScrees.PROFILE
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_profile),
                                    contentDescription = "profile",
                                    tint = if (selectedItem.value == HomeScrees.PROFILE) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "Profile",
                                    style = itemTextStyle(selectedItem.value == HomeScrees.PROFILE)
                                )
                            })

                        BottomNavigationItem(selected = selectedItem.value == HomeScrees.MORE,
                            onClick = {
                                selectedItem.value = HomeScrees.MORE
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_more),
                                    contentDescription = "more",
                                    tint = if (selectedItem.value == HomeScrees.MORE) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "More",
                                    style = itemTextStyle(selectedItem.value == HomeScrees.MORE)
                                )
                            })
                    }
                }
            }
        ) {}
    }
}

fun itemTextStyle(isSelected: Boolean): TextStyle {
    return TextStyle(
        color = if (isSelected) orange else placeholderColor,
        fontSize = 12.sp,
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.Medium
    )
}