package com.example.costadelsabor.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.costadelsabor.R
import com.example.costadelsabor.ui.UiButton
import com.example.costadelsabor.ui.UiInput
import com.example.costadelsabor.ui.UiSwitcher


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navigationToStart: () -> Unit,
    navigationToMain: () -> Unit,
) {
    var rememberMe by remember { mutableStateOf(false) }
    var emailAddress by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    val modifier = Modifier

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            navigationIcon = {
                IconButton(onClick = { navigationToStart() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
        )
    }
    )
    { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(74.dp)
                    .width(200.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Sing Up",
                fontSize = 28.sp,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(top = 26.dp)
            )
            Spacer(modifier = Modifier.height(76.dp))
            UiInput(
                value = emailAddress,
                onValueChange = { newMailInput ->
                    emailAddress = newMailInput
                },
                title = stringResource(id = R.string.email_address)
            )
            Spacer(modifier = Modifier.height(20.dp))
            UiInput(
                value = userName,
                onValueChange = { newUserNameInput ->
                    userName = newUserNameInput
                },
                title = stringResource(id = R.string.write_user_name)
            )
            Spacer(modifier = Modifier.height(20.dp))
            UiInput(
                value = userPassword,
                onValueChange = { newUserPasswordInput ->
                    userPassword = newUserPasswordInput
                },
                title = stringResource(id = R.string.write_password)
            )
            Spacer(modifier = Modifier.height(34.dp))
            UiSwitcher(
                title = stringResource(R.string.remember_me),
                value = rememberMe,
                onCheckedChange = { newValue ->
                    rememberMe = newValue

                }
            )
            Spacer(modifier = Modifier.height(46.dp))
            UiButton(
                title = stringResource(id = R.string.sing_up),
                onCLick = { navigationToMain() },
                color = R.color.unfocIndicatorColor_log_page
            )
            Spacer(modifier = Modifier.height(145.dp))

        }

    }
}

@Preview
@Composable
private fun SingUpScreenPreview() {
    RegisterScreen({}, {})
}