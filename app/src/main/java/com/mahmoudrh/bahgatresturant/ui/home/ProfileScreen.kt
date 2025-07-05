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
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.theme.secondaryFontColor
import com.mahmoudrh.bahgatresturant.ui.theme.white

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileScreen(){
    val scrollState = rememberScrollState()
    BahgatResturantTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(state = scrollState)) {
            AppTopBar(title = stringResource(R.string.profile), backIcon = false)
            Spacer(modifier = Modifier.height(30.dp))
            ProfileImage(image = R.drawable.profile_picture)
            TextButtonWithImage(textButton = stringResource(R.string.edit_profile), image = R.drawable.ic_edit){}
            Text(stringResource(R.string.jane_doe), style = TextStyle(fontFamily = metropolisFontFamily, color = primaryFontColor, fontSize = 16.sp, fontWeight = FontWeight.Bold))
            SignOut(textButton = stringResource(R.string.signout)){}
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = stringResource(R.string.full_name))
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = stringResource(R.string.email))
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = stringResource(R.string.mobile_no))
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = stringResource(R.string.address))
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = stringResource(R.string.password))
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(hint = stringResource(R.string.confirm_password))
            Spacer(modifier = Modifier.height(20.dp))
            FilledButton(text = stringResource(R.string.save), modifier = Modifier.padding(horizontal = 30.dp)) {}
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

@Preview
@Composable
private fun ProfilePrev() {
    Surface { ProfileScreen() }
}