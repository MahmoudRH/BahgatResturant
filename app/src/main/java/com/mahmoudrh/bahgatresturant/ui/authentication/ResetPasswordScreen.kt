package com.mahmoudrh.bahgatresturant.ui.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ResetPasswordScreen(navigateToEmailVerificationScreen:()->Unit) {
    BahgatResturantTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Reset Password",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Please enter your email to receive a link to  create a new password via email",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = secondaryFontColor,
                    fontFamily = metropolisFontFamily,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(horizontal = 60.dp)
            )
            Spacer(modifier = Modifier.height(60.dp))
            AppTextField(
                hint = "Your Email",
                action = ImeAction.Done,
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(34.dp))
            FilledButton(text = "Send", modifier = Modifier.padding(horizontal = 34.dp)) {

                navigateToEmailVerificationScreen()
            }
        }
    }
}