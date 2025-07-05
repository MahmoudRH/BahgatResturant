package com.mahmoudrh.bahgatresturant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudrh.bahgatresturant.R
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTextField
import com.mahmoudrh.bahgatresturant.ui.ui_components.AppTopBar
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.ButtonWithImage
import com.mahmoudrh.bahgatresturant.ui.ui_components.buttons.FilledButton
import com.mahmoudrh.bahgatresturant.ui.ui.theme.BahgatResturantTheme
import com.mahmoudrh.bahgatresturant.ui.ui.theme.gray2
import com.mahmoudrh.bahgatresturant.ui.ui.theme.metropolisFontFamily
import com.mahmoudrh.bahgatresturant.ui.ui.theme.orange
import com.mahmoudrh.bahgatresturant.ui.ui.theme.primaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.secondaryFontColor
import com.mahmoudrh.bahgatresturant.ui.ui.theme.white
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CheckoutScreen() {
    var currentBottomSheet: BottomSheetType? by remember {
        mutableStateOf(null)
    }

    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden
    )

    val scope = rememberCoroutineScope()

    val closeSheet = {
        scope.launch { modalBottomSheetState.hide() }
    }

    val openSheet = {
        scope.launch { modalBottomSheetState.show() }
    }

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(20.dp),
        sheetContent = {
            Spacer(modifier = Modifier.height(1.dp))
            currentBottomSheet?.let {
                SheetLayout(
                    closeSheet = { closeSheet() },
                    bottomSheetType = it
                )
            }
        }
    ) {
        BahgatResturantTheme {
            val selectedGender = remember { mutableStateOf("") }
            val list = listOf<String>("Samer", "Mohammed", "Ahmed")
            BahgatResturantTheme() {
                Column(modifier = Modifier.background(white)) {
                    AppTopBar(title = "Checkout", backIcon = true)

                    Box(modifier = Modifier.background(white)) {
                        Column(modifier = Modifier.padding(15.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Delivery Address", style = TextStyle(color = secondaryFontColor, fontFamily = metropolisFontFamily, fontSize = 13.sp))
                                TextButton(onClick = {}) {
                                    Text(
                                        "Change",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = orange,
                                            fontFamily = metropolisFontFamily,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }
                            Text(text = "653 Nostrand Ave., \n" + "Brooklyn, NY 11216" , style = TextStyle(color = primaryFontColor, fontFamily = metropolisFontFamily, fontSize = 15.sp, fontWeight = FontWeight.Bold))
                        }
                    }

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .background(gray2))

                    Box(modifier = Modifier.background(white)) {
                        Column(modifier = Modifier.padding(15.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Payment Method", style = TextStyle(color = secondaryFontColor, fontFamily = metropolisFontFamily, fontSize = 13.sp))
                                TextButton(onClick = {currentBottomSheet = BottomSheetType.AddCreditBottomSheet
                                    openSheet()}) {
                                    Text(
                                        "+ Add Cart",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = orange,
                                            fontFamily = metropolisFontFamily,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }
                            LazyColumn {
                                items(list) { item ->
                                    Box(
                                        modifier = Modifier.background(
                                            gray2,
                                            shape = RoundedCornerShape(15.dp)
                                        )
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(
                                                    start = 20.dp,
                                                    end = 5.dp,
                                                    top = 5.dp,
                                                    bottom = 5.dp
                                                ),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = item, style = TextStyle(color = primaryFontColor, fontFamily = metropolisFontFamily, fontSize = 14.sp))
                                            RadioButton(
                                                selected = selectedGender.value == item,
                                                onClick = {
                                                    selectedGender.value = item
                                                })
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .background(gray2))

                    Box(modifier = Modifier.background(white)) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Sub Total",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    )
                                )
                                Text(
                                    text = "15$",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    ),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Delivery Cost",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    )
                                )
                                Text(
                                    text = "15$",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    ),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Discount",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    )
                                )
                                Text(
                                    text = "15$",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    ),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Divider()
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Total",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    )
                                )
                                Text(
                                    text = "15$",
                                    style = TextStyle(
                                        fontFamily = metropolisFontFamily,
                                        fontSize = 15.sp,
                                        color = primaryFontColor
                                    ),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .background(gray2))

                    FilledButton(text = "Send Order", modifier = Modifier.padding(20.dp)) {
                        currentBottomSheet = BottomSheetType.SendOrderBottomSheet
                        openSheet()
                    }
                }
            }

        }
    }
}

@Composable
fun SheetLayout(bottomSheetType: BottomSheetType, closeSheet: () -> Unit) {
    when (bottomSheetType) {
        BottomSheetType.AddCreditBottomSheet -> AddCreditBottomSheet(closeSheet)
        BottomSheetType.SendOrderBottomSheet -> SendOrderBottomSheet(closeSheet)
    }
}

enum class BottomSheetType() {
    AddCreditBottomSheet, SendOrderBottomSheet
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddCreditBottomSheet(closeSheet: () -> Unit) {
    Column() {
        Text(text = "Add Credit/Debit Card", modifier = Modifier.padding(20.dp), style = TextStyle(color = primaryFontColor, fontWeight = FontWeight.Bold, fontFamily = metropolisFontFamily, fontSize = 15.sp))
        Divider()
        Spacer(modifier = Modifier.height(18.dp))
        AppTextField(hint = "Card Number")
        Spacer(modifier = Modifier.height(18.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            AppTextField(hint = "MM", modifier = Modifier.fillMaxWidth(0.5f))
            AppTextField(hint = "YY", modifier = Modifier.fillMaxWidth(1f))
        }
        Spacer(modifier = Modifier.height(18.dp))
        AppTextField(hint = "Security Code")
        Spacer(modifier = Modifier.height(18.dp))
        AppTextField(hint = "First Name")
        Spacer(modifier = Modifier.height(18.dp))
        AppTextField(hint = "Last Name")
        Spacer(modifier = Modifier.height(18.dp))
        ButtonWithImage(
            text = "Add tis Cart",
            image = R.drawable.ic_add,
            color = orange,
            modifier = Modifier.padding(horizontal = 30.dp)
        ) {closeSheet()}
        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Composable
fun SendOrderBottomSheet(closeSheet: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.thanks), contentDescription = "")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Thank You", style = TextStyle(color = primaryFontColor, fontWeight = FontWeight.Bold, fontFamily = metropolisFontFamily, fontSize = 17.sp))
        Text(text = "for your order", style = TextStyle(color = primaryFontColor, fontWeight = FontWeight.Bold, fontFamily = metropolisFontFamily, fontSize = 15.sp))
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "Your Order is now being processed. We will let you know once the order is picked from the outlet. Check the status of your Order",
            textAlign = TextAlign.Center
            , style = TextStyle(color = primaryFontColor, fontFamily = metropolisFontFamily, fontSize = 15.sp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        FilledButton(text = "Go To Home") {closeSheet()}
    }
}
