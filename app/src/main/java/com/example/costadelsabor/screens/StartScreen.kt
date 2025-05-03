package com.example.costadelsabor.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.costadelsabor.R
import com.example.costadelsabor.ui.UiButton
import com.example.costadelsabor.ui.UiButtonImage
import com.example.costadelsabor.ui.UiInput

@Composable
fun StartScreen(
    navigateToRegister: () -> Unit,
    navigateToMain: () -> Unit,
    navigaionToWelcome: () -> Unit
) {
    val modifier = Modifier
    /* remeber позволяет сохранить состояние(Когда произойдут изменения в inputEmailAddress(ниже по коду)
       То вместо того чтобы перерисовывать все он перерисует только там где обращались к переменной)) */
    var inputEmailAddress by remember { mutableStateOf("") }
    //если захочу изменить знач. то меняю через *название переменной*.value = "new value"

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.title_log_page),
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(top = 105.dp),
                color = colorResource(id = R.color.title_log_page),
                style = TextStyle(fontWeight = FontWeight.Bold),
            )
            Spacer(modifier = Modifier.height(71.dp))
            UiButtonImage(
                onCLick = { /*TODO*/ },
                title = stringResource(id = R.string.facebook),
                color = R.color.facebook_button,
                image = R.drawable.facebook_logo
            )
            Spacer(modifier = Modifier.height(10.dp))
            UiButtonImage(
                onCLick = { /*TODO*/ },
                title = stringResource(id = R.string.twitter),
                color = R.color.x_button,
                image = R.drawable.twitter
            )
            Spacer(modifier = Modifier.height(10.dp))
            UiButtonImage(
                onCLick = { /*TODO*/ },
                title = stringResource(id = R.string.google),
                color = R.color.google_button,
                image = R.drawable.google
            )
            Spacer(modifier = Modifier.height(39.dp))
            Text(
                text = "or",
                fontSize = 15.sp,
                color = colorResource(id = R.color.OR_page_LogIn),
            )
            Spacer(modifier = Modifier.height(26.dp))
            UiInput(
                value = inputEmailAddress,
                onValueChange = { newMailInput ->
                    inputEmailAddress = newMailInput
                },
                title = stringResource(id = R.string.email_address)
            )
            Spacer(modifier = Modifier.height(43.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.already_have_an_account),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.OR_page_LogIn)
                )
                Text(
                    text = stringResource(R.string.sign_in),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .clickable { navigaionToWelcome() }
                )

            }
            Spacer(modifier = Modifier.height(25.dp))
            UiButton(
                onCLick = { navigateToRegister() },
                color = R.color.unfocIndicatorColor_log_page,
                title = stringResource(R.string.create_an_account)
            )
            Row(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 103.dp),
            ) {
                Text(text = stringResource(R.string.skip_login),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.x_button),
                    modifier = Modifier
                        .padding(start = 121.dp)
                        .clickable { navigateToMain() }
                )
                Text(text = stringResource(R.string.sing_up),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.x_button),
                    modifier = Modifier
                        .padding(end = 108.dp)
                        .clickable { navigateToRegister() }
                )
            }
        }
    }
}

@Preview
@Composable
private fun LogScreenPreview() {
    StartScreen({}, {}, {})
}