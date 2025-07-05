package com.mahmoudrh.bahgatresturant.ui.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.ui_components.Footer
import com.mahmoudrh.bahgatresturant.ui.ui_components.VerifyTextField
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor
import com.mahmoudrh.bahgatresturant.utils.FakeOtpManager
import kotlinx.coroutines.launch

@Composable
fun EmailVerificationScreen(navigateToChangePasswordScreen: () -> Unit) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var otp by remember { mutableStateOf("") }
    BahgatResturantTheme {
        Scaffold(scaffoldState = scaffoldState) { _ ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 50.dp),
                    text = stringResource(R.string.we_have_sent_an_otp_to_your_mobile),
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = metropolisFontFamily,
                        color = primaryFontColor,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.please_check_your_mobile_number),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = secondaryFontColor,
                        fontFamily = metropolisFontFamily,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 50.dp)
                )
                Spacer(modifier = Modifier.height(54.dp))
                VerifyTextField(value = otp, onValueChanged = { otp = it }, codeLength = 4)
                Spacer(modifier = Modifier.height(36.dp))
                FilledButton(
                    text = stringResource(R.string.next),
                    modifier = Modifier.padding(horizontal = 34.dp)
                ) {
                    if (FakeOtpManager.checkVerificationCode(otp))
                        navigateToChangePasswordScreen()
                    else {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(R.string.error_invalid_code),
                                actionLabel = context.getString(R.string.try_again)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Footer(
                    text = stringResource(R.string.didn_t_receive),
                    textButton = stringResource(R.string.click_here)
                ) {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            context.getString(R.string.verification_code_is) + FakeOtpManager.getVerificationCode(),
                            actionLabel = context.getString(R.string.ok)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun EmailVerificationPrev() {
    EmailVerificationScreen { }
}

