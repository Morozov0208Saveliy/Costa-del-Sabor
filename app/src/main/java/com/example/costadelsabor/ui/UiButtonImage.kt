package com.example.costadelsabor.ui

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.costadelsabor.R

@Composable
fun UiButtonImage(
    title: String = "",
    onCLick: () -> Unit,
    color: Int ,
    image: Int,
    modifier: Modifier = Modifier

) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = color)
        ),
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = title,
            modifier = modifier
                .size(22.dp)
                .padding(end = 4.dp),
            contentScale = ContentScale.Fit,
        )
        Text(
            text = title,
            fontSize = 17.sp,
            style = MaterialTheme.typography.headlineMedium
        )
    }

}

@Preview
@Composable
private fun UiButtonImagePreview() {
    UiButtonImage(
        title = stringResource(id = R.string.sing_up),
        onCLick = {},
        color = R.color.facebook_button,
        image = R.drawable.facebook_logo
    )

}