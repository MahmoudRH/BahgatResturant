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
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.ui_components.Footer
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navigateToSignInScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = stringResource(R.string.sign_up),
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold,
                color = primaryFontColor
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.add_your_details_to_sign_up),
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Medium,
                color = secondaryFontColor,
            )
        )

        Spacer(modifier = Modifier.height(36.dp))
        AppTextField(hint = stringResource(R.string.name))
        Spacer(modifier = Modifier.height(28.dp))
        AppTextField(hint = stringResource(R.string.email), keyboardType = KeyboardType.Email)
        Spacer(modifier = Modifier.height(28.dp))
        AppTextField(hint = stringResource(R.string.mobile_no), keyboardType = KeyboardType.Phone)
        Spacer(modifier = Modifier.height(28.dp))
        AppTextField(hint = stringResource(R.string.address))
        Spacer(modifier = Modifier.height(28.dp))
        AppTextField(hint = stringResource(R.string.password), keyboardType = KeyboardType.Password)
        Spacer(modifier = Modifier.height(28.dp))
        AppTextField(
            hint = stringResource(R.string.confirm_password),
            keyboardType = KeyboardType.Password,
            action = ImeAction.Done
        )
        Spacer(modifier = Modifier.height(28.dp))
        FilledButton(text = stringResource(R.string.sign_up), modifier = Modifier.padding(horizontal = 34.dp)) {}
        Spacer(modifier = Modifier.height(28.dp))
        Footer(
            text = stringResource(R.string.already_have_an_account),
            textButton = stringResource(R.string.login),
        ) {
            navigateToSignInScreen()
        }
    }
}

@Preview
@Composable
private fun SignUpPrev() {
    Surface {
        SignUpScreen { }
    }
}
