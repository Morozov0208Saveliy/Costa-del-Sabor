package com.example.costadelsabor.screens

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector? = null,
    val route: String = ""
)