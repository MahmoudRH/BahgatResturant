package com.mahmoudrh.bahgatresturant.model.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.model.More
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor

class About(override var icon: Int = 0, override var name: String = "") : More {

    override fun setObjectToSend(): More {
        return About()
    }

    @Composable
    override fun setContent() {
        val list = listOf(
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
        )
        BahgatResturantTheme() {
            Column {
                AppTopBar(title = "About Us")
                Spacer(modifier = Modifier.height(15.dp))
                LazyColumn{
                    items(list) { item ->
                        Column() {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 20.dp)) {
                                Icon(painter = painterResource(id = R.drawable.ic_circle), contentDescription = "", tint = orange)
                                Spacer(modifier = Modifier.width(30.dp))
                                Text(item, style = TextStyle(fontSize = 15.sp, fontFamily = metropolisFontFamily, color = primaryFontColor))
                            }
                        }
                    }
                }
            }
        }
    }
}