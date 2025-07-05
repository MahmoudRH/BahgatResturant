package com.mahmoudrh.bahgatresturant.ui.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ButtonWithImage
import com.mahmoudrh.bahgatresturant.ui.FilledButton
import com.mahmoudrh.bahgatresturant.ui.Footer
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.blue
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.red
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInScreen(
    navigateToResetPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    BahgatResturantTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = primaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Add your details to login",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = secondaryFontColor,
                    fontWeight = FontWeight.Medium,
                    fontFamily = metropolisFontFamily
                )
            )
            Spacer(modifier = Modifier.height(36.dp))
            AppTextField(hint = "Your Email", keyboardType = KeyboardType.Email)
            Spacer(modifier = Modifier.height(28.dp))
            AppTextField(
                hint = "Password",
                keyboardType = KeyboardType.Password,
                action = ImeAction.Done
            )
            Spacer(modifier = Modifier.height(28.dp))

            FilledButton(
                text = "Sign In",
                modifier = Modifier.padding(horizontal = 34.dp)
            ) {

                //temporary
                navigateToHomeScreen()
            }
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(onClick = {
                navigateToResetPasswordScreen()
            }) {
                Text(
                    "Forgot your password?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = secondaryFontColor,
                        fontFamily = metropolisFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                modifier = Modifier.padding(top = 9.dp),
                text = "or login with",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = secondaryFontColor,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(28.dp))
            ButtonWithImage(
                text = "Login with Facebook",
                image = R.drawable.ic_facebook,
                modifier = Modifier.padding(horizontal = 34.dp),
                color = blue
            ) {}
            Spacer(modifier = Modifier.height(28.dp))
            ButtonWithImage(
                text = "Login with Google",
                image = R.drawable.ic_google,
                modifier = Modifier.padding(horizontal = 34.dp),
                color = red
            ) {}
            Spacer(modifier = Modifier.height(28.dp))
            Footer(
                text = "Don't have an Account?",
                textButton = "Sign Up",
            ) {
                navigateToSignUpScreen()
            }
        }
    }
}






