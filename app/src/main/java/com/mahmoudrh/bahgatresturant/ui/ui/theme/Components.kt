package com.mahmoudrh.bahgatresturant.ui.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R

@Composable
fun Logo(modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = orange,
                    )
                ) {
                    append("Bahgat ")
                }
                append("Food")
            }, style = TextStyle(
                color = primaryFontColor,
                fontFamily = cabinFontFamily,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.size(7.dp))
        Text(
            text = "FOOD DELIVERY",
            fontFamily = metropolisFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = primaryFontColor
        )
    }
}

@Composable
fun FilledButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = orange),
        shape = RoundedCornerShape(28.dp),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun BorderButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(width = 1.dp, color = orange),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = orange,
                fontSize = 16.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun AppTextField(modifier: Modifier = Modifier, hint: String, keyboardType: KeyboardType = KeyboardType.Text, action:ImeAction = ImeAction.Next) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        value = textFieldState,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = gray,
            cursorColor = orange,
            disabledLabelColor = gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            textFieldState = it
        },
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    color = placeholderColor,
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        },
        shape = RoundedCornerShape(28.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = action),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            onDone = { keyboardController?.hide() }
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = primaryFontColor,
            fontSize = 14.sp,
            fontFamily = metropolisFontFamily
        ),
        visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
    )
}

@Composable
fun Footer(modifier: Modifier = Modifier, text: String, textButton: String, onClick: () -> Unit) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                color = secondaryFontColor,
                fontFamily = metropolisFontFamily
            )
        )
        TextButton(onClick = onClick) {
            Text(
                textButton,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = orange,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun ButtonWithImage(
    modifier: Modifier = Modifier,
    image: Int,
    color: Color,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = RoundedCornerShape(28.dp),
        elevation = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "icon",
            )
            Text(
                modifier = Modifier.padding(start = 33.dp),
                text = text,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}
