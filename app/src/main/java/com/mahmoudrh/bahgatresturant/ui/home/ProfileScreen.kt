package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.white

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileScreen(){
    val scrollState = rememberScrollState()
    BahgatResturantTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(state = scrollState)) {
            AppTopBar(title = "Profile", backIcon = false)
            Spacer(modifier = Modifier.height(30.dp))
            ProfileImage(image = R.drawable.profile_picture)
            TextButtonWithImage(textButton = "edit Profile", image = R.drawable.ic_edit){}
            Text("Samer Mushtaha", style = TextStyle(fontFamily = metropolisFontFamily, color = primaryFontColor, fontSize = 16.sp, fontWeight = FontWeight.Bold))
            SignOut("SignOut"){}
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = "Full name")
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = "Email")
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = "Mobile no")
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = "Address")
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = "Password")
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = "Confirm password")
            Spacer(modifier = Modifier.height(20.dp))
            FilledButton(text = "Save", modifier = Modifier.padding(horizontal = 30.dp)) {}
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier, image: Int) {
    Box(
        modifier = modifier
            .background(white, shape = RoundedCornerShape(200.dp)),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun TextButtonWithImage(textButton: String, image: Int, onClick: () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = image), contentDescription = null)
        Spacer(modifier = Modifier.width(2.dp))
        TextButton(onClick = onClick) {
            Text(
                textButton,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = orange,
                    fontFamily = metropolisFontFamily,
                )
            )
        }
    }
}

@Composable
fun SignOut(textButton: String, onClick: () -> Unit){
    TextButton(onClick = onClick) {
        Text(
            textButton,
            style = TextStyle(
                fontSize = 14.sp,
                color = secondaryFontColor,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold
            )
        )
    }
}