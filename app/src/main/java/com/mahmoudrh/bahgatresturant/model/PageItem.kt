package com.mahmoudrh.bahgatresturant.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PageItem(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val subTitle: Int
)