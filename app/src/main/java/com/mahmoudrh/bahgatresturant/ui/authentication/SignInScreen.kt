package com.mahmoudrh.bahgatresturant.ui.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.blue
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.red
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ui_components.Footer
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.ButtonWithImage
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInScreen(
    navigateToResetPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = stringResource(R.string.login),
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold,
                color = primaryFontColor
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.add_your_details_to_login),
            style = TextStyle(
                fontSize = 14.sp,
                color = secondaryFontColor,
                fontWeight = FontWeight.Medium,
                fontFamily = metropolisFontFamily
            )
        )
        Spacer(modifier = Modifier.height(36.dp))
        AppTextField(hint = stringResource(R.string.your_email), keyboardType = KeyboardType.Email)
        Spacer(modifier = Modifier.height(28.dp))
        AppTextField(
            hint = stringResource(R.string.password),
            keyboardType = KeyboardType.Password,
            action = ImeAction.Done
        )
        Spacer(modifier = Modifier.height(28.dp))

        FilledButton(
            text = stringResource(R.string.sign_in),
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
                stringResource(R.string.forgot_your_password),
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
            text = stringResource(R.string.or_login_with),
            style = TextStyle(
                fontSize = 14.sp,
                color = secondaryFontColor,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(28.dp))
        ButtonWithImage(
            text = stringResource(R.string.login_with_facebook),
            image = R.drawable.ic_facebook,
            modifier = Modifier.padding(horizontal = 34.dp),
            color = blue
        ) {}
        Spacer(modifier = Modifier.height(28.dp))
        ButtonWithImage(
            text = stringResource(R.string.login_with_google),
            image = R.drawable.ic_google,
            modifier = Modifier.padding(horizontal = 34.dp),
            color = red
        ) {}
        Spacer(modifier = Modifier.height(28.dp))
        Footer(
            text = stringResource(R.string.don_t_have_an_account),
            textButton = stringResource(R.string.sign_up),
        ) {
            navigateToSignUpScreen()
        }
    }
}

@Preview
@Composable
private fun SignInScreenPrev() {
    Surface {
        SignInScreen(
            navigateToResetPasswordScreen = {},
            navigateToSignUpScreen = {},
            navigateToHomeScreen = {}
        )
    }
}




