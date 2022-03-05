package com.mahmoudrh.bahgatresturant.ui.home


import MoreDetailsScreen
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.More
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.placeholderColor

private enum class HomeScreens {
    MENU,
    OFFERS,
    HOME,
    PROFILE,
    MORE
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavigation() {
    val selectedItem = remember { mutableStateOf(HomeScreens.HOME) }
    val navController = rememberAnimatedNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        //-> Main Container ~90% of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.93f)
        ) {
            HomeNavHost(navHostController = navController)

            //-> Navigate when the selected item changes..
            navController.popBackStack()
            navController.navigate(route = selectedItem.value.name)
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
                    backgroundColor = if (selectedItem.value == HomeScreens.HOME) orange else placeholderColor,
                    onClick = { selectedItem.value = HomeScreens.HOME },
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
                        BottomNavigationItem(selected = selectedItem.value == HomeScreens.MENU,
                            onClick = { selectedItem.value = HomeScreens.MENU },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_menu),
                                    contentDescription = "menu",
                                    tint = if (selectedItem.value == HomeScreens.MENU) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "Menu",
                                    style = navItemTextStyle(selectedItem.value == HomeScreens.MENU)
                                )
                            })

                        BottomNavigationItem(selected = selectedItem.value == HomeScreens.OFFERS,
                            onClick = { selectedItem.value = HomeScreens.OFFERS },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_shopping_bag),
                                    contentDescription = "offers",
                                    tint = if (selectedItem.value == HomeScreens.OFFERS) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "Offers",
                                    style = navItemTextStyle(selectedItem.value == HomeScreens.OFFERS)
                                )
                            })

                        BottomNavigationItem(selected = selectedItem.value == HomeScreens.PROFILE,
                            onClick = { selectedItem.value = HomeScreens.PROFILE },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_profile),
                                    contentDescription = "profile",
                                    tint = if (selectedItem.value == HomeScreens.PROFILE) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "Profile",
                                    style = navItemTextStyle(selectedItem.value == HomeScreens.PROFILE)
                                )
                            })

                        BottomNavigationItem(selected = selectedItem.value == HomeScreens.MORE,
                            onClick = { selectedItem.value = HomeScreens.MORE },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_more),
                                    contentDescription = "more",
                                    tint = if (selectedItem.value == HomeScreens.MORE) orange else placeholderColor
                                )
                            },
                            label = {
                                Text(
                                    text = "More",
                                    style = navItemTextStyle(selectedItem.value == HomeScreens.MORE)
                                )
                            })
                    }
                }
            }
        ) {}
    }
}

private fun navItemTextStyle(isSelected: Boolean): TextStyle {
    return TextStyle(
        color = if (isSelected) orange else placeholderColor,
        fontSize = 12.sp,
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.Medium
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun HomeNavHost(navHostController: NavHostController) {
    AnimatedNavHost(navController = navHostController, startDestination = HomeScreens.HOME.name) {

        composable(
            route = HomeScreens.HOME.name,
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) {
            HomeScreen()
        }

        composable(
            route = HomeScreens.MENU.name,
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) {
            MenuScreen()
        }

        composable(
            route = HomeScreens.OFFERS.name,
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) {
            OffersScreen()
        }

        composable(
            route = HomeScreens.PROFILE.name,
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) {
            ProfileScreen()
        }

        composable(
            route = HomeScreens.MORE.name,
            popEnterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) {
            MoreScreen {content ->
                navHostController.currentBackStackEntry?.arguments?.putSerializable("content", content)
                navHostController.navigate("MoreDetailsScreen/{content}")
            }
        }

        composable(
            route = "MoreDetailsScreen/{content}",
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) {
            val content = navHostController.previousBackStackEntry?.arguments?.getSerializable("content") as More?
            if (content != null) {
                MoreDetailsScreen(content)
            }
        }

    }
}