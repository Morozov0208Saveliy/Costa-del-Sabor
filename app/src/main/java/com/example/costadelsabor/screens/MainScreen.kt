package com.example.costadelsabor.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.costadelsabor.R
import com.example.costadelsabor.ui.DishItem
import com.example.costadelsabor.ui.NavigationDrawerHeader
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.items

@Composable
fun MainScreen( navController: NavController) {
    val dishes = listOf(
        Dish(1, R.drawable.carry),
        Dish(1, R.drawable.carry)
    )
//    val categories = listOf()
//    val favorites = listOf()
    val drawerState = rememberDrawerState(DrawerValue.Closed) //?
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerHeader(
                    userName = "John Doe",
                    userId = "53248922",
                    avatar = painterResource(R.drawable.twitter)
                )

                NavigationDrawer(
                    onItemClick = { item ->
                        scope.launch { drawerState.close() }
                        navController.navigate(item.route)
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                AppBar { scope.launch { drawerState.open() } }
            },
            content = { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                ) {
//                    item { Spacer(modifier = Modifier.padding(32.dp)) }
                    item {
                        Text(
                            text = "Hello!",
                            fontSize = 24.sp,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }
                    item { Spacer(modifier = Modifier.padding(2.dp)) }
                    item {
                        Text(
                            text = "Elevate your Wedding with our exquisite Catering Menu",
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }
                    item { Spacer(modifier = Modifier.padding(10.dp)) }
                    item {
                        LazyRow {
                            items(dishes) { dish ->  // Теперь работает!
                                DishItem(dish = dish)
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(24.dp)) }
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Menu Categories",
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                            Text(
                                text = "View all",
                                fontSize = 13.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(end = 12.dp)
                            )
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(10.dp)) }
                    item {
                        LazyRow {
                            items(dishes) { dish ->
                                DishItem(dish = dish)
                            }
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(10.dp)) }
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Favourites",
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                            Text(
                                text = "View all",
                                fontSize = 13.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(end = 12.dp)
                            )
                        }
                    }
                    item { Spacer(modifier = Modifier.padding(10.dp)) }
                    item {
                        LazyRow {
                            items(dishes) { dish ->
                                DishItem(dish = dish)
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = { Text("") },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open menu"
                )
            }
        }
    )
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(navController = NavController(LocalContext.current))
}