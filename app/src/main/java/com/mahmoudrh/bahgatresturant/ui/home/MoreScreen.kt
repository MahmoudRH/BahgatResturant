package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.More
import com.mahmoudrh.bahgatresturant.model.more.*
import com.mahmoudrh.bahgatresturant.ui.AppTopBar

import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

@Composable
fun MoreScreen(onMoreItemClick: (content: More) -> Unit) {
    val list = arrayOf(
        Payment(name = "Payment Method", icon = R.drawable.ic_income),
        MyOrder(name = "MyOrder", icon = R.drawable.ic_shopping_bag),
        Notification(name = "Notification", icon = R.drawable.ic_notification),
        Inbox(name = "Inbox", icon = R.drawable.ic_inbox),
        About(name = "About Us", icon = R.drawable.ic_info),
    )

    BahgatResturantTheme {
        Column {
            AppTopBar(title = "More", backIcon = false)
            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(list) { item ->
                    Box(modifier = Modifier
                        .padding(end = 20.dp)) {
                        Box(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                                .fillMaxWidth()
                                .clickable { onMoreItemClick(item.setObjectToSend()) }
                                .background(gray2, shape = RoundedCornerShape(7.dp))
                        ) {
                            Row(
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(start = 20.dp, top = 10.dp, bottom = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(55.dp)
                                        .height(55.dp)
                                        .background(gray3, RoundedCornerShape(100.dp))
                                ) {
                                    Image(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = "",
                                        modifier = Modifier.align(
                                            Alignment.Center
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(
                                    text = item.name,
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 14.sp,
                                        color = primaryFontColor
                                    )
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .background(gray2, RoundedCornerShape(100.dp))
                                .align(Alignment.CenterEnd)
                                .padding(end = 5.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_forward),
                                contentDescription = "",
                                tint = secondaryFontColor,
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                            )
                        }
                    }
                }
            }
        }
    }
}