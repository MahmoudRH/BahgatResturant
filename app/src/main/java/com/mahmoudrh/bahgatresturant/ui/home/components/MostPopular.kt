package com.mahmoudrh.bahgatresturant.ui.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmoudrh.bahgatresturant.model.PopularRestaurant

@Composable
fun MostPopular(list: List<PopularRestaurant>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item { Spacer(modifier = Modifier.size(12.dp)) }
        items(list) { item ->
            MostPopularItem(item, modifier = Modifier.fillParentMaxWidth(0.8f))
        }
        item { Spacer(modifier = Modifier.size(12.dp)) }

    }
}
