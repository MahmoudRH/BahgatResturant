package com.mahmoudrh.bahgatresturant.ui.weclome

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

@Composable
fun WelcomeScreen(navigateToSignIn:()-> Unit , navigateToSignUp:()-> Unit) {
    BahgatResturantTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopSection()
            Spacer(modifier = Modifier.size(46.dp))
            Text(
                text = "Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontFamily = metropolisFontFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            FilledButton(
                modifier = Modifier
                    .padding(horizontal = 34.dp)
                    .padding(top = 56.dp),
                text = "Login"
            ) {
                navigateToSignIn()
            }
            BorderButton(
                modifier = Modifier
                    .padding(horizontal = 34.dp, vertical = 24.dp),
                text = "Create an Account",
            ) {
                navigateToSignUp()
            }
        }
    }
}

@Composable
private fun TopSection() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.ic_sign_in_top),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 88.dp),
            contentScale = ContentScale.FillWidth,
        )
        Logo(modifier = Modifier.align(Alignment.BottomCenter))
    }

}