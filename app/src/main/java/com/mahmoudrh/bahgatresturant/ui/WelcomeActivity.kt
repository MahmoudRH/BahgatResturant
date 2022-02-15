package com.mahmoudrh.bahgatresturant.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BahgatResturantTheme {
                Column(
                    modifier = Modifier.fillMaxWidth(),
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
                            .fillMaxWidth(0.9f)
                            .padding(top = 56.dp),
                        text = "Login"
                    ) {
                    /** To Login Screen*/
                    }
                    BorderButton(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 24.dp),
                        text = "Create an Account"
                    ) {
                     /** To Sign Up Screen*/
                    }
                }
            }
        }
    }
}

@Composable
private fun TopSection(){
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