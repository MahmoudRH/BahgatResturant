package com.mahmoudrh.bahgatresturant.model.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
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
import com.mahmoudrh.bahgatresturant.ui.theme.gray2
import com.mahmoudrh.bahgatresturant.ui.theme.gray4
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.placeholderColor
import com.mahmoudrh.bahgatresturant.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar

data class InboxItem(val title: String, val subTitle: String, val date: String)

class Inbox(override var icon: Int = 0, override var name: String = "") : More {


    @Composable
    override fun SetContent() {
        val list = listOf(
            InboxItem("Your orders has been picked up", "Your orders has been picked up", "12:00"),
            InboxItem("Your orders has been picked up", "Your orders has been picked up", "12:00"),
            InboxItem("Your orders has been picked up", "Your orders has been picked up", "12:00"),
            InboxItem("Your orders has been picked up", "Your orders has been picked up", "12:00"),
        )
        Column {
            AppTopBar(title = "Inbox")
            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn {
                items(list) { item ->
                    Box(modifier = Modifier.background(gray2)) {
                        Column(modifier = Modifier.align(Alignment.Center)) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 20.dp)
                            )
                            {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_circle),
                                    contentDescription = "",
                                    tint = orange
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Column() {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            item.title,
                                            style = TextStyle(
                                                fontSize = 15.sp,
                                                fontFamily = metropolisFontFamily,
                                                color = primaryFontColor
                                            )
                                        )
                                        Text(
                                            item.date,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontFamily = metropolisFontFamily,
                                                color = placeholderColor
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            item.subTitle,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontFamily = metropolisFontFamily,
                                                color = placeholderColor
                                            )
                                        )
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_stare),
                                            contentDescription = "",
                                            tint = orange
                                        )
                                    }
                                }
                            }
                            Divider(color = gray4, modifier = Modifier.padding(horizontal = 20.dp))
                        }
                    }
                }
            }
        }
    }

}