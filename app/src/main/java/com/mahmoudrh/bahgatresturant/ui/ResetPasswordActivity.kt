package com.mahmoudrh.bahgatresturant.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*

class ResetPasswordActivity : ComponentActivity() {
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
                        text = "Reset Password",
                        style = TextStyle(fontSize = 30.sp, fontFamily = metropolisFontFamily, color = primaryFontColor)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Please enter your email to receive a link to  create a new password via email",
                        style = TextStyle(fontSize = 14.sp, color = secondaryFontColor, fontFamily = metropolisFontFamily, textAlign = TextAlign.Center),
                        modifier = Modifier.padding(horizontal = 60.dp)
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    AppTextField(hint = "Your Email")
                    Spacer(modifier = Modifier.height(34.dp))
                    FilledButton(text = "Send", modifier = Modifier.padding(horizontal = 34.dp)) {
                        startActivity(Intent(this@ResetPasswordActivity, EmailVerificationActivity::class.java))
                    }
                }
            }
        }
    }
}