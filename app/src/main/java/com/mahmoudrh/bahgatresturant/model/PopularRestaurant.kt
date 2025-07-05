package com.mahmoudrh.bahgatresturant.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PopularRestaurant(
    @StringRes val name: Int,
    val rate: Float,
    val rateCount: Int,
    @StringRes val foodKind: Int,
    @DrawableRes val coverImage: Int
)

