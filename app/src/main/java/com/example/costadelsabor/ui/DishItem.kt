package com.example.costadelsabor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.screens.Dish

@Composable
fun DishItem(dish: Dish) {
    Column(
        modifier = Modifier.padding(start = 17.dp)
    ) {
        Image(
            painter = painterResource(id = dish.imageRes),
            contentDescription = "image",
            modifier = Modifier
                .height(213.dp)
                .width(330.dp)
        )
        dish.title?.let { Text(text = it) }
        dish.description?.let { Text(text = it) }
    }
}