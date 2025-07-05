package com.mahmoudrh.bahgatresturant.ui.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ResetPasswordScreen(navigateToEmailVerificationScreen: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = stringResource(R.string.reset_password),
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = metropolisFontFamily,
                color = primaryFontColor
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.please_enter_your_email_to_receive_a_linkl),
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
            hint = stringResource(R.string.your_email),
            action = ImeAction.Done,
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(34.dp))
        FilledButton(
            text = stringResource(R.string.send),
            modifier = Modifier.padding(horizontal = 34.dp)
        ) {
            navigateToEmailVerificationScreen()
        }
    }
}

@Preview
@Composable
private fun ResetPasswordPrev() {
    Surface {
        ResetPasswordScreen { }
    }
}