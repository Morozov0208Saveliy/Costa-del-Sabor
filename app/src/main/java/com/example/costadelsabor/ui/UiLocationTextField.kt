package com.example.costadelsabor.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.R

@Composable
fun UiLocationTextField(
    selectedLocation: String,
    onLocationClick: () -> Unit
) {
    var focused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .padding(start = 19.dp, end = 4.dp)
            .clickable(onClick = onLocationClick)
            .border(
                width = 1.dp,
                color = if (focused) colorResource(R.color.teal_700)
                else colorResource(R.color.unfocIndicatorColor_log_page),
                shape = MaterialTheme.shapes.small
            )
            .focusable()
            .onFocusChanged { focused = it.isFocused }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (selectedLocation.isEmpty()) "Location"
                else selectedLocation,
                color = if (selectedLocation.isEmpty()) LocalContentColor.current.copy(alpha = 0.3f)
                else LocalContentColor.current
            )
            Icon(
                painter = painterResource(R.drawable.location),
                contentDescription = "Choose location",
                tint = colorResource(R.color.black)
            )
        }
    }
}

@Preview
@Composable
private fun UiLocationTextFieldPreview() {
    UiLocationTextField(
        selectedLocation = "Main Restaurant",
        onLocationClick = {}
    )
}