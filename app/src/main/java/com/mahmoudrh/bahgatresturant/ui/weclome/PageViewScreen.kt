package com.mahmoudrh.bahgatresturant.ui.weclome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.PageItem
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.OutlinedButton
import kotlinx.coroutines.launch

private val list = arrayOf(
    PageItem(
        image = R.drawable.ic_page_1,
        title = R.string.welcome_title_1,
        subTitle = R.string.welcome_subtitle_1
    ),
    PageItem(
        image = R.drawable.ic_page_2,
        title = R.string.welcome_title_2,
        subTitle = R.string.welcome_subtitle_2
    ),
    PageItem(
        image = R.drawable.ic_page_3,
        title = R.string.welcome_title_3,
        subTitle = R.string.welcome_subtitle_3
    )
)

@Composable
fun PageViewScreen(navigateToWelcomeScreen: () -> Unit) {
    val pagerState = rememberPagerState { list.size }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(state = pagerState) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(list[index].image), contentDescription = null)
                Spacer(modifier = Modifier.height(30.dp))
                Indicator(count = list.size, index = index)
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = stringResource(list[index].title),
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = metropolisFontFamily,
                        color = primaryFontColor
                    )
                )
                Spacer(modifier = Modifier.height(33.dp))
                Text(
                    text = stringResource(list[index].subTitle),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = metropolisFontFamily,
                        color = secondaryFontColor,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 45.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        FilledButton(
            modifier = Modifier.padding(horizontal = 34.dp),
            text = stringResource(R.string.next)
        ) {
            scope.launch {
                if (pagerState.currentPage < list.size - 1) {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                } else {
                    navigateToWelcomeScreen()
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            modifier = Modifier.padding(horizontal = 34.dp),
            text = stringResource(R.string.skip),
            color = secondaryFontColor
        ) {
            navigateToWelcomeScreen()
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun Indicator(count: Int, index: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until count) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(if (i == index) orange else Color.LightGray)
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Preview
@Composable
private fun PageViewPrev() {
    Surface() { PageViewScreen { } }
}