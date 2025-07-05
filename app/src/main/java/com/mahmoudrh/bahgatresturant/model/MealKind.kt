package com.mahmoudrh.bahgatresturant.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MealKind(
    @StringRes val name: Int,
    @DrawableRes val image: Int
)