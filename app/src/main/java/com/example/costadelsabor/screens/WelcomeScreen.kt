package com.example.costadelsabor.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
fun WelcomeScreen(
    navigationToStart: () -> Unit,
    navigationToMain: () -> Unit,
    ) {

    val modifier = Modifier
    var emailAddress by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    val annotatedText = buildAnnotatedString {
        append("By connecting your account confirm that you agree\nwith our ")
        pushStringAnnotation(
            tag = "TERMS_LINK",
            annotation = "https://your-terms-link.com"
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.black),
            )
        ) {
            append("Term and Condition")
        }
        pop()
    }

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
                text = "Welcome",
                fontSize = 28.sp,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(top = 26.dp)
            )
            Text(
                text = "Please enter your data to continue",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.OR_page_LogIn)
            )
            Spacer(modifier = Modifier.height(52.dp))
            UiInput(
                value = emailAddress,
                onValueChange = { newEmailInput ->
                    emailAddress = newEmailInput
                },
                title = stringResource(R.string.email_address),

                )
            Spacer(modifier = Modifier.height(19.dp))
            UiInput(
                value = userPassword,
                onValueChange = {
                    userPassword = it
                },
                title = stringResource(R.string.write_password)
            )
            Spacer(modifier = Modifier.height(19.dp))
            Row(
                modifier = Modifier
                    .padding(top = 19.dp, bottom = 19.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    stringResource(R.string.forgot_password),
                    style = TextStyle(fontWeight = FontWeight.Medium),
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.height(19.dp))
            UiSwitcher(
                title = stringResource(R.string.remember_me),
                value = rememberMe,
                onCheckedChange = { newValue ->
                    rememberMe = newValue

                }
            )
            Spacer(modifier = Modifier.height(26.dp))
            ClickableText(
                text = annotatedText,
                modifier = Modifier
                    .padding(top = 26.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.OR_page_LogIn)
                )
            ) { offset ->
                annotatedText.getStringAnnotations(
                    tag = "TERMS_LINK",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    Log.d("LINK", "Clicked: ${annotation.item}")
                }
            }
            Spacer(modifier = Modifier.height(44.dp))
            UiButton(
                onCLick = { navigationToMain() },
                color = R.color.unfocIndicatorColor_log_page,
                title = stringResource(R.string.sing_up)
            )
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen({}, {})
}