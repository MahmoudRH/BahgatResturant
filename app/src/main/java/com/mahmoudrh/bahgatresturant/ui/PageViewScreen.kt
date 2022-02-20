package com.mahmoudrh.bahgatresturant.ui

import androidx.annotation.RestrictTo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.PageItem
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PageViewScreen(navigateToWelcomeScreen: () -> Unit){
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val list = arrayOf(PageItem(image = R.drawable.ic_page_1, title = "Find Food You Love", subTitle = "Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep"), PageItem(image = R.drawable.ic_page_2, title = "Fast Delivery", subTitle = "Fast food delivery to your home, office wherever you are"), PageItem(image = R.drawable.ic_page_3, title = "Live Tracking", subTitle = "Real time tracking of your food on the app once you placed the order"))
    BahgatResturantTheme {
        HorizontalPager(
            count = list.size,
            state = pagerState
        ) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = list[index].image), contentDescription = null)
                Spacer(modifier = Modifier.height(70.dp))
                Text(
                    text = list[index].title,
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = metropolisFontFamily,
                        color = primaryFontColor
                    )
                )
                Spacer(modifier = Modifier.height(33.dp))
                Text(
                    text = list[index].subTitle,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = metropolisFontFamily,
                        color = secondaryFontColor,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 45.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                FilledButton(text = "Next", modifier = Modifier.padding(horizontal = 34.dp)) {
                    scope.launch {
                        if (index < list.size - 1) {
                            pagerState.animateScrollToPage(index + 1)
                        } else {
                            navigateToWelcomeScreen()
                        }
                    }
                }
            }
        }
    }
}
