package com.mahmoudrh.bahgatresturant.ui.authentication

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahmoudrh.bahgatresturant.ui.FilledButton
import com.mahmoudrh.bahgatresturant.ui.Footer
import com.mahmoudrh.bahgatresturant.ui.VerifyTextField
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import com.mahmoudrh.bahgatresturant.viewmodels.ResetPasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun EmailVerificationScreen(navigateToChangePasswordScreen: () -> Unit) {
    val resetPasswordViewModel = viewModel<ResetPasswordViewModel>()
//    val snackbarHostState = remember { SnackbarHostState() }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    BahgatResturantTheme {
        Scaffold(scaffoldState = scaffoldState) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 50.dp),
                    text = "We have sent an OTP to your Mobile",
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = metropolisFontFamily,
                        color = primaryFontColor,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Please check your mobile number 071*****12 continue to reset your password",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = secondaryFontColor,
                        fontFamily = metropolisFontFamily,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 50.dp)
                )
                Spacer(modifier = Modifier.height(54.dp))
                VerifyTextField(viewModel = resetPasswordViewModel)
                Spacer(modifier = Modifier.height(36.dp))
                FilledButton(text = "Next", modifier = Modifier.padding(horizontal = 34.dp)) {
                    if (resetPasswordViewModel.checkVerificationCode())
                        navigateToChangePasswordScreen()
                    else {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Error: Invalid Code", actionLabel = "Try Again")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Footer(text = "Didn't Receive?", textButton = "Click Here") {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Verification Code is: " + resetPasswordViewModel.getVC(), actionLabel = "OK")
                    }
                }
            }
        }
    }
}


