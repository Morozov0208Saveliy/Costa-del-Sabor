package com.example.costadelsabor.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.costadelsabor.R

@Composable
fun UiButton(
    title: String = "",
    onCLick: () -> Unit,
    color: Int,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onCLick() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = color)
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 63.dp, end = 70.dp),
    ) {
        Text(
            text = title,
            fontSize = 17.sp,
            style = MaterialTheme.typography.headlineMedium
        )
    }


}

@Preview
@Composable
private fun UiButtonPreview() {
    UiButton(title = stringResource(id = R.string.sing_up), onCLick = {}, color = R.color.unfocIndicatorColor_log_page)
}
