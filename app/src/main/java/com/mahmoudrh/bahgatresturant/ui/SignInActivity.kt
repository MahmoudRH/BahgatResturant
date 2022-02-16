package com.mahmoudrh.bahgatresturant.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import java.util.*

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BahgatResturantTheme {
                Box(Modifier.fillMaxSize()){
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(60.dp))
                        Text(
                            text = "Sign In",
                            style = TextStyle(fontSize = 30.sp, fontFamily = metropolisFontFamily, color = primaryFontColor)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Add your details to log in",
                            style = TextStyle(fontSize = 14.sp, color = secondaryFontColor, fontFamily = metropolisFontFamily)
                        )
                        Spacer(modifier = Modifier.height(36.dp))
                        AppTextField(hint = "Your Email")
                        Spacer(modifier = Modifier.height(28.dp))
                        AppTextField(hint = "Password")
                        Spacer(modifier = Modifier.height(28.dp))
                        FilledButton(text = "Sign In", modifier = Modifier.padding(horizontal = 34.dp)) {}
                        Spacer(modifier = Modifier.height(24.dp))
                        TextButton(onClick = {startActivity(Intent(this@SignInActivity, ResetPasswordActivity::class.java))}) {
                            Text("Forget your password?", style = TextStyle(fontSize = 14.sp, color = secondaryFontColor, fontFamily = metropolisFontFamily, fontWeight = FontWeight.Bold))
                        }
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(
                            modifier = Modifier.padding(top = 9.dp),
                            text = "or login with",
                            style = TextStyle(fontSize = 14.sp, color = secondaryFontColor, fontFamily = metropolisFontFamily)
                        )
                        Spacer(modifier = Modifier.height(28.dp))
                        ButtonWithImage(text = "Login with Facebook", image = R.drawable.ic_facebook, modifier = Modifier.padding(horizontal = 34.dp), color = blue) {}
                        Spacer(modifier = Modifier.height(28.dp))
                        ButtonWithImage(text = "Login with Google", image = R.drawable.ic_google, modifier = Modifier.padding(horizontal = 34.dp), color = red) {}
                    }
                    Footer(text = "Don't have an Account?", textButton = "Sign Up", modifier = Modifier.align(Alignment.BottomCenter)){
                        startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
                    }
                }
            }
        }
    }
}



