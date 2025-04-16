package com.example.costadelsabor.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.costadelsabor.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SideNav() {

    val items = listOf(
//        SideNavItem(
//            image = painterResource(id = R.drawable.logo),
//            user = "User",
//            userId = 123
//        ),
        SideNavItem(title = "Services"),
        SideNavItem(title = "Packages"),
        SideNavItem(title = "Categories"),
        SideNavItem(title = "Custom Orders"),
        SideNavItem(title = "Settings"),
        SideNavItem(title = "Help Center"),
        SideNavItem(title = "Log Out")
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf(items[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                //как алтернатива я могу просто здесь захаркодить фото пользователя и т.д
                items.forEach { item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title ?: "")
                        },
                        selected = selectedItem.value == item,
                        onClick = {
                            scope.launch {
                                selectedItem.value = item
                                drawerState.close()//после нажатия закроет менюшку
                            }
                        }
                    )
                }
            }
        },
        content = {
            Scaffold(topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "",
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Back"
                            )
                        }
                    },
                )
            }
            ) {

            }
        }
    )
}

data class SideNavItem(
    val image: Painter? = null,
    val user: String? = null,
    val userId: Int? = null,
    val title: String? = null,
)
