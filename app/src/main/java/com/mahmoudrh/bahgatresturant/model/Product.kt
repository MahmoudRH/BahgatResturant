package com.mahmoudrh.bahgatresturant.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val des: Int,
    val rate: Float,
    @StringRes val type: Int
)