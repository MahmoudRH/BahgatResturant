package com.mahmoudrh.bahgatresturant.ui.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.ui.theme.gray
import com.mahmoudrh.bahgatresturant.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.utils.noRippleClickable


@Composable
fun VerifyTextField(
    modifier: Modifier = Modifier, value: String, onValueChanged: (String) -> Unit, codeLength: Int
) {
    val focusRequester = remember { FocusRequester() }

    Box(modifier) {
        Box(modifier = Modifier.noRippleClickable() { focusRequester.requestFocus() }) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(codeLength) { index ->
                    val char = value.getOrNull(index)?.toString() ?: "*"
                    val isSelected = value.length == index
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            Modifier
                                .background(gray, RoundedCornerShape(percent = 12))
                                .border(
                                    2.dp,
                                    if (isSelected) orange else Color.Transparent,
                                    RoundedCornerShape(percent = 12)
                                )
                                .padding(horizontal = 20.dp, vertical = 12.dp),
                        ) {
                            Text(
                                char,
                                style = TextStyle(
                                    color = primaryFontColor,
                                    fontSize = 37.sp,
                                    fontFamily = metropolisFontFamily
                                ),
                            )
                        }
                    }
                }
            }

            BasicTextField(
                value = value,
                onValueChange = {
                    if (it.length <= codeLength && it.all { ch -> ch.isDigit() }) {
                        onValueChanged(it)
                    }
                },
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .alpha(0f)
                    .size(1.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword, imeAction = ImeAction.Done
                ),
                singleLine = true
            )
        }
    }
}

@Preview()
@Composable
private fun OTPTextFieldFilledPrev() {
    var value by remember { mutableStateOf("123") }
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp)
    ) {
        VerifyTextField(
            value = value, onValueChanged = { value = it }, codeLength = 4
        )
    }
}
