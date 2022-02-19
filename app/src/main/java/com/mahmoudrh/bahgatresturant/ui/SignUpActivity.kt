package com.mahmoudrh.bahgatresturant.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

class SignUpActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BahgatResturantTheme {
                Box(Modifier.fillMaxSize()){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(60.dp))
                        Text(
                            text = "Sign Up",
                            style = TextStyle(fontSize = 30.sp, fontFamily = metropolisFontFamily, fontWeight = FontWeight.Bold, color = primaryFontColor )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Add your details to sign up",
                            style = TextStyle(fontSize = 14.sp, fontFamily = metropolisFontFamily, fontWeight = FontWeight.Medium, color = secondaryFontColor,)
                        )
                        Spacer(modifier = Modifier.height(36.dp))
                        AppTextField(hint = "Name")
                        Spacer(modifier = Modifier.height(28.dp))
                        AppTextField(hint = "Email", keyboardType = KeyboardType.Email)
                        Spacer(modifier = Modifier.height(28.dp))
                        AppTextField(hint = "Mobile no", keyboardType = KeyboardType.Phone)
                        Spacer(modifier = Modifier.height(28.dp))
                        AppTextField(hint = "Address")
                        Spacer(modifier = Modifier.height(28.dp))
                        AppTextField(hint = "Password", keyboardType = KeyboardType.Password)
                        Spacer(modifier = Modifier.height(28.dp))
                        AppTextField(hint = "Confirm password", keyboardType = KeyboardType.Password, action = ImeAction.Done)
                        Spacer(modifier = Modifier.height(28.dp))
                        FilledButton(text = "Sign Up", modifier = Modifier.padding(horizontal = 34.dp)) {}
                    }
                    Footer(text = "Already have an Account?", textButton = "Login", modifier = Modifier.align(Alignment.BottomCenter)){
//                        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                    }
                }

            }
        }
    }

}