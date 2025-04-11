package com.example.costadelsabor.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.costadelsabor.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun WelcomeScreen() {

    val modifier = Modifier
    var emailAddress by remember { mutableStateOf("Write mail address") }
    var userName by remember { mutableStateOf("Write user name") }
    var rememberMe by remember { mutableStateOf(false) }

    val annotatedText = buildAnnotatedString {
        append("By connecting your account confirm that you agree\nwith our ")
        pushStringAnnotation(
            tag = "TERMS_LINK",
            annotation = "https://your-terms-link.com"
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.unfocIndicatorColor_log_page),
            )
        ) {
            append("Term and Condition")
        }
        pop()
    }

    Scaffold(topBar = {
        TopAppBar(
//            modifier = Modifier
//                .padding(start = 45.dp
//                ),
            title = {
                Text(
                    text = "",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
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

            OutlinedTextField(
                value = emailAddress,
                onValueChange = { newMailInput ->
                    emailAddress = newMailInput
                },
                label = {
                    Text(stringResource(id = R.string.email_address))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.teal_700),
                    unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 52.dp, start = 20.dp, end = 5.dp)
            )

            OutlinedTextField(
                value = userName,
                onValueChange = { newNameInput ->
                    userName = newNameInput
                },
                label = {
                    Text(stringResource(R.string.write_user_name))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.teal_700),
                    unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp, end = 5.dp)
            )

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

            Row(
                modifier = Modifier
                    .padding(start = 20.dp, end = 13.dp, top = 34.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    stringResource(R.string.remember_me),
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.black),
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )
                Switch(
                    checked = rememberMe,
                    onCheckedChange = { newCheckedState ->
                        rememberMe = newCheckedState
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                        uncheckedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                        uncheckedThumbColor = colorResource(id = R.color.title_log_page),
                        uncheckedTrackColor = colorResource(id = R.color.white),
                    ),
                    modifier = Modifier
                        .padding(start = 206.dp)
                        .size(30.dp),
                )
            }

            ClickableText(
                text = annotatedText,
                modifier = Modifier.padding(top = 26.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
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

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.unfocIndicatorColor_log_page)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 63.dp, end = 70.dp, top = 44.dp, bottom = 145.dp),
            ) {
                Text(
                    text = stringResource(R.string.sing_up),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}