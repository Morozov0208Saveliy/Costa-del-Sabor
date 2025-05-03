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
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.R
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UiTimeTextField(
    timeText: String,
    onTimeClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .clickable { onTimeClick() }
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
                    text = timeText.ifEmpty { "Time" },
                    color = if (timeText.isEmpty()) LocalContentColor.current.copy(alpha = 0.3f)
                    else LocalContentColor.current,
                )
                Icon(
                    painter = painterResource(id = R.drawable.access_time_24),
                    contentDescription = "Time",
                    tint = colorResource(id = R.color.black)
                )
            }
        }
    }
}

@Preview
@Composable
private fun UiTimeTextFieldPreview() {
    UiTimeTextField(timeText = "13:00", onTimeClick = {})
}