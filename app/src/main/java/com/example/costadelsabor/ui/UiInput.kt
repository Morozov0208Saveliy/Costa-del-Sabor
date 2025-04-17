package com.example.costadelsabor.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.R

@Composable
fun UiInput(
    value: String,
    onValueChange: (String) -> Unit,
    title: String = "",
    modifier: Modifier = Modifier

) {
    OutlinedTextField(
        value = value,
        onValueChange = { newMailInput ->
        onValueChange.invoke(newMailInput)  //функция с нуля не из кеша (ПОЧИТАЙ)
        },
        label = {
            Text(title)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.teal_700),
            unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 5.dp)
    )

}

@Preview
@Composable
private fun UiInputPreview() {
    UiInput(value = "", onValueChange = {}, title = stringResource(id = R.string.email_address))
}
