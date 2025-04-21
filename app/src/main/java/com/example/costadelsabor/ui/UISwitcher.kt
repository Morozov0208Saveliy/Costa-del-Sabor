package com.example.costadelsabor.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.costadelsabor.R

@Composable
fun UiSwitcher(
    title: String = "",
    onCheckedChange: (Boolean) -> Unit = {},
    value: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // Распределяем элементы по ширине
    ) {
        Text(
            text = title,
            fontSize = 13.sp,
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Medium
        )
        Switch(
            checked = value,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                uncheckedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                uncheckedThumbColor = colorResource(id = R.color.title_log_page),
                uncheckedTrackColor = colorResource(id = R.color.white),
                checkedTrackColor = colorResource(id = R.color.teal_700)
            )
        )
    }
}

@Preview
@Composable
private fun UiSwitcherPreview() {
    UiSwitcher(title = "Remember me", value = true, onCheckedChange = {})
}