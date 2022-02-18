package com.mahmoudrh.bahgatresturant.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

class EmailVerificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BahgatResturantTheme {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(60.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 50.dp),
                        text = "We have sent an OTP to your Mobile",
                        style = TextStyle(fontSize = 25.sp, fontFamily = metropolisFontFamily, color = primaryFontColor, textAlign = TextAlign.Center)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Please check your mobile number 071*****12 continue to reset your password",
                        style = TextStyle(fontSize = 14.sp, color = secondaryFontColor, fontFamily = metropolisFontFamily, textAlign = TextAlign.Center),
                        modifier = Modifier.padding(horizontal = 50.dp)
                    )
                    Spacer(modifier = Modifier.height(54.dp))
                    VerifyTextField()
                    Spacer(modifier = Modifier.height(36.dp))
                    FilledButton(text = "Next", modifier = Modifier.padding(horizontal = 34.dp)) {
                        startActivity(Intent(this@EmailVerificationActivity, ChangePasswordActivity::class.java))
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Footer(text = "Didn't Receive?", textButton = "Click Here") {}
                }
            }
        }
    }
}