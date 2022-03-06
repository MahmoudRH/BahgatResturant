package com.mahmoudrh.bahgatresturant.model

import androidx.compose.runtime.Composable
import java.io.Serializable

interface More: Serializable {
    var icon: Int
    var name: String

    fun setObjectToSend(): More

    @Composable
    fun setContent()

}