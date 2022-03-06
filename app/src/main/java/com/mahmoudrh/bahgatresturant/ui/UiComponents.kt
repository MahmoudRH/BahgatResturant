package com.mahmoudrh.bahgatresturant.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import com.mahmoudrh.bahgatresturant.viewmodels.ResetPasswordViewModel
import kotlinx.coroutines.launch

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
fun FilledButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 16,
    onClick: () -> Unit
) {
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
                fontSize = fontSize.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun BorderButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = orange,
    fontSize: Int = 16,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(width = 1.dp, color = color),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = color,
                fontSize = fontSize.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalComposeUiApi
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    action: ImeAction = ImeAction.Next,
    rounded: Int = 28,
    fontSize: Int = 14,
) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .onFocusEvent { focusState ->
                if (focusState.isFocused) {
                    coroutineScope.launch {
                        bringIntoViewRequester.bringIntoView()
                    }
                }
            },
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
                    fontSize = fontSize.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        },
        shape = RoundedCornerShape(rounded.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = action),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }
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
fun Footer(text: String, textButton: String, onClick: () -> Unit) {
    Row(
        Modifier
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun VTextFiled(
    value: String,
    onValueChanged: (String) -> Unit,
    action: ImeAction = ImeAction.Next
) {
//    var value by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    BasicTextField(
        modifier = Modifier
            .width(56.dp)
            .height(56.dp)
            .onKeyEvent {
                if (it.key.keyCode != Key.Backspace.keyCode) {
                    if (action == ImeAction.Next) {
                        focusManager.moveFocus(FocusDirection.Right)
                    } else {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                } else {
                    if (value.isEmpty()) {
                        focusManager.moveFocus(FocusDirection.Left)
                    }
                }
                true
            },
        value = value,
        onValueChange = { onValueChanged(it) },
//        {
//            value = if (it.isNotEmpty()) it[0].toString() else ""
//        }
        decorationBox = { innerTextField ->
            Box(
                Modifier
                    .background(gray, RoundedCornerShape(percent = 12))
                    .padding(start = 20.dp, top = 12.dp)
            ) {
                if (value.isEmpty()) {
                    Text(
                        "*",
                        style = TextStyle(
                            color = primaryFontColor,
                            fontSize = 37.sp,
                            fontFamily = metropolisFontFamily
                        ),
                    )
                }
                innerTextField()
            }
        },
        textStyle = TextStyle(
            color = primaryFontColor,
            fontSize = 25.sp,
            fontFamily = metropolisFontFamily
        ),
        singleLine = true,
        cursorBrush = SolidColor(orange),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = action
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Right) },
            onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }
        ),
    )
}

@Composable
fun VerifyTextField(viewModel: ResetPasswordViewModel, codeLength: Int = 4) {
    Row(
        modifier = Modifier.padding(horizontal = 28.dp),
        horizontalArrangement = Arrangement.spacedBy(28.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0..codeLength - 2) {
            VTextFiled(
                value = viewModel.verificationCodeValue(i),
                onValueChanged = { viewModel.onVerificationCodeChanged(it,index =  i) }
            )
        }
        VTextFiled(
            action = ImeAction.Done,
            value = viewModel.verificationCodeValue(codeLength - 1),
            onValueChanged = { viewModel.onVerificationCodeChanged(it, index = codeLength - 1) }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField() {
    var value by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 17.dp),
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = gray,
            cursorColor = orange,
            disabledLabelColor = gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            value = it
        },
        placeholder = {
            Text(
                text = "Search food",
                style = TextStyle(
                    color = placeholderColor,
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        },
        shape = RoundedCornerShape(28.dp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                /** do something*/
                /** do something*/

                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/

                /** do something*/
                keyboardController?.hide()
            }
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = primaryFontColor,
            fontSize = 15.sp,
            fontFamily = metropolisFontFamily
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search icon",
                modifier = Modifier.padding(start = 14.dp)
            )
        }
    )
}

@Composable
fun AppTopBar(backIcon: Boolean = false, title: String, action: Boolean = true) {

    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor
                )
            )
        },
        actions = {
            if (action) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = com.mahmoudrh.bahgatresturant.R.drawable.ic_cart),
                        contentDescription = "",
                        tint = primaryFontColor
                    )
                }
            }
        },
        backgroundColor = white,
        elevation = 0.dp,
        navigationIcon = if (backIcon) {
            {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = com.mahmoudrh.bahgatresturant.R.drawable.ic_back),
                        contentDescription = "",
                        tint = primaryFontColor
                    )
                }
            }
        } else null
    )
}

@Composable
fun IconButton(modifier: Modifier = Modifier, image: Int, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .height(50.dp)
            .width(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = white),
        shape = RoundedCornerShape(100.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
        )
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "",
            tint = orange
        )
    }
}