package com.example.costadelsabor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.costadelsabor.screens.DateAndLocationScreen
import com.example.costadelsabor.screens.InitScreen
import com.example.costadelsabor.screens.SideNav
import com.example.costadelsabor.screens.SingUpScreen
import com.example.costadelsabor.ui.theme.CostaDelSaborTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideNav()
        }
    }
}

