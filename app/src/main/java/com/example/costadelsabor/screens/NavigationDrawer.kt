package com.example.costadelsabor.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal val navItems = listOf(
    NavigationItem(title = "Services", route = "services"),
    NavigationItem(title = "Packages", route = "packages"),
    NavigationItem(title = "Categories", route = "categories"),
    NavigationItem(title = "Custom Orders", route = "custom orders"),
    NavigationItem(title = "Settings", route = "settings"),
    NavigationItem(title = "Help Center", route = "help center"),
    NavigationItem(title = "Log Out", route = "log out")
)

@Composable
fun NavigationDrawer(
    onItemClick: (NavigationItem) -> Unit
) {
    var selectedItem by remember { mutableStateOf(navItems.first().route) }
    navItems.forEach { item ->
        NavigationDrawerItem(
            label = { Text(text = item.title) },
            selected = selectedItem == item.route,
            icon = item.icon?.let {
                { Icon(imageVector = it, contentDescription = item.title) }
            },
            onClick = { onItemClick(item)
                      selectedItem = item.route},
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}