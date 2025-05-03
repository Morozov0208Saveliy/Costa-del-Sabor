package com.example.costadelsabor.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.R

@Composable
fun UiDateTextField(
    dateText: String,
    onDateClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .clickable { onDateClick() }
            .padding(start = 19.dp, end = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.unfocIndicatorColor_log_page),
                    shape = MaterialTheme.shapes.small
                )
                .padding(vertical = 16.dp, horizontal = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = dateText.ifEmpty { "Date" },
                    color = if (dateText.isEmpty()) LocalContentColor.current.copy(alpha = 0.3f)
                    else LocalContentColor.current,
                )

                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Open Date",
                    tint = colorResource(id = R.color.black)
                )
            }
        }
    }
}

@Preview
@Composable
private fun DateTextFieldPreview(){
    UiDateTextField(dateText = "12/05/2023", onDateClick = {})
}