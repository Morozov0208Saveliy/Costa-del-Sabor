package com.example.costadelsabor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.R

@Composable
fun NavigationDrawerHeader(
    userName: String,
    userId: String,
    avatar: Painter
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = avatar,
            contentDescription = "User avatar",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = userName,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 77.dp)
        )
        Text(
            text = "ID: $userId",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 77.dp, top = 20.dp)
        )
    }
}

@Composable
@Preview
private fun NavigationDrawerHeaderPreview() {
    NavigationDrawerHeader(
        userName = "John Doe",
        userId = "53248922",
        avatar = painterResource(R.drawable.twitter)
    )
}