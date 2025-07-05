package com.mahmoudrh.bahgatresturant.ui.home


import MoreDetailsScreen
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.more.More
import com.mahmoudrh.bahgatresturant.model.more.moreScreens
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.placeholderColor

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
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
        backgroundColor = Color.White,
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                cutoutShape = CircleShape,
                backgroundColor = Color.White,
                elevation = 0.dp,
                contentPadding = PaddingValues(all = 5.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomBarItem(
                        iconRes = R.drawable.ic_menu,
                        titleRes = R.string.menu,
                        isSelected = selectedItem.value == HomeScreens.MENU,
                        onClick = { selectedItem.value = HomeScreens.MENU }
                    )
                    BottomBarItem(
                        iconRes = R.drawable.ic_shopping_bag,
                        titleRes = R.string.offers,
                        isSelected = selectedItem.value == HomeScreens.OFFERS,
                        onClick = { selectedItem.value = HomeScreens.OFFERS }
                    )
                    BottomBarItem(
                        iconRes = R.drawable.ic_profile,
                        titleRes = R.string.profile,
                        isSelected = selectedItem.value == HomeScreens.PROFILE,
                        onClick = { selectedItem.value = HomeScreens.PROFILE }
                    )
                    BottomBarItem(
                        iconRes = R.drawable.ic_more,
                        titleRes = R.string.more,
                        isSelected = selectedItem.value == HomeScreens.MORE,
                        onClick = { selectedItem.value = HomeScreens.MORE }
                    )
                }
            }
        }
    ) {

        Surface(
            modifier = Modifier
                .padding(it)
                .padding(top = 20.dp)
        ) {
            HomeNavHost(navHostController = navController)

            navController.popBackStack()
            navController.navigate(route = selectedItem.value.name)
        }
    }
}

@Preview
@Composable
private fun HomePrev() {
    HomeNavigation()
}

@Composable
fun RowScope.BottomBarItem(
    @DrawableRes iconRes: Int,
    @StringRes titleRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    BottomNavigationItem(
        selected = isSelected,
        onClick = onClick,
        icon = {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = stringResource(titleRes),
                tint = if (isSelected) orange else placeholderColor
            )
        },
        label = {
            Text(
                text = stringResource(titleRes),
                style = navItemTextStyle(isSelected)
            )
        })

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
    NavHost(navController = navHostController, startDestination = HomeScreens.HOME.name) {

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
            MoreScreen { content ->
                val encodedContent = content?.toUri()
                navHostController.navigate("MoreDetailsScreen/$encodedContent")
            }
        }

        composable(
            route = "MoreDetailsScreen/{content}",
            arguments = listOf(navArgument("content") { type = NavType.StringType }),
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
        ) { navBackStackEntry ->
            // Retrieve content from the current back stack entry's arguments
            val content = navBackStackEntry.arguments?.getString("content")
            val screen = content?.let { moreScreens[it] }
            if (screen != null) {
                MoreDetailsScreen(screen)
            } else {
                // Handle null case, e.g., navigate back or show error
                Text("Error: Screen not found")
            }
        }

    }
}

