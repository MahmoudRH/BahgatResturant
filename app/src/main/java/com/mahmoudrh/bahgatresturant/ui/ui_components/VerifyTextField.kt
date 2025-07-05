package com.mahmoudrh.bahgatresturant.ui.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.ui.ui.theme.gray
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.viewmodels.ResetPasswordViewModel




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
private fun VTextFiled(
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



