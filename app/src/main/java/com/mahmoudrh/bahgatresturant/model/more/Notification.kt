package com.mahmoudrh.bahgatresturant.model.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.mahmoudrh.bahgatresturant.model.More
import com.mahmoudrh.bahgatresturant.ui.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

data class NotificationItem(val title: String, val date: String)

class Notification(override var icon: Int = 0, override var name: String = "") : More {

    override fun setObjectToSend(): More {
        return Notification()
    }

    @Composable
    override fun setContent() {
        val list = listOf(
            NotificationItem("Your orders has been picked up", "12:00"),
            NotificationItem("Your orders has been picked up", "12:00"),
            NotificationItem("Your orders has been picked up", "12:00"),
            NotificationItem("Your orders has been picked up", "12:00"),
        )
        BahgatResturantTheme() {
            Column {
                AppTopBar(title = "Notification")
                Spacer(modifier = Modifier.height(15.dp))
                LazyColumn{
                    items(list) { item ->
                        Box(modifier = Modifier.background(gray2)){
                            Column(modifier = Modifier.align(Alignment.Center)) {
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 20.dp, vertical = 20.dp)) {
                                    Icon(painter = painterResource(id = R.drawable.ic_circle), contentDescription = "", tint = orange)
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Column() {
                                        Text(item.title, style = TextStyle(fontSize = 15.sp, fontFamily = metropolisFontFamily, color = primaryFontColor))
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(item.date, style = TextStyle(fontSize = 12.sp, fontFamily = metropolisFontFamily, color = placeholderColor))
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

}