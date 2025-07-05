package com.mahmoudrh.bahgatresturant.ui.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmoudrh.bahgatresturant.model.MealKind

@Composable
fun MealKinds(list: List<MealKind>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item { Spacer(modifier = Modifier.size(12.dp)) }
        items(list) { item ->
            MealKind(item)
        }
        item { Spacer(modifier = Modifier.size(12.dp)) }

    }
}
