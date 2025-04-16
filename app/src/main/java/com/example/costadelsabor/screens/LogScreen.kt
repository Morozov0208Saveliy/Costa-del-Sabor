package com.example.costadelsabor.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.costadelsabor.R

@Preview
@Composable
fun LogScreen() {
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
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.facebook_button)
                ),
                modifier = Modifier
                    .padding(top = 71.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook_logo),
                    contentDescription = "Facebook logo",
                    modifier = Modifier
                        .size(22.dp)
                        .padding(end = 4.dp),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = stringResource(id = R.string.facebook),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.x_button)
                ),
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.twitter),
                    contentDescription = "Google logo",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = stringResource(id = R.string.twitter),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.headlineMedium
                )

            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.google_button)
                ),
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google logo",
                    modifier = Modifier
                        .size(22.dp)
                        .padding(end = 4.dp),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = stringResource(id = R.string.google),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Text(
                text = "or",
                fontSize = 15.sp,
                color = colorResource(id = R.color.OR_page_LogIn),
                modifier = Modifier
                    .padding(top = 39.dp, end = 26.dp)
            )
            OutlinedTextField(
                value = inputEmailAddress,
                onValueChange = { newInput ->
                    inputEmailAddress = newInput
                },
                label = {
                    Text(stringResource(R.string.email_address))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.teal_700),
                    unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page),
                ),
                modifier = Modifier
                    .padding(top = 26.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .padding(top = 43.dp)
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
                        .clickable {}
                )

            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.unfocIndicatorColor_log_page)
                ),
                modifier = Modifier
                    .padding(top = 25.dp, start = 74.dp, end = 59.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.create_an_account),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.headlineMedium
                )

            }
            Row(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 103.dp),
            ) {
                Text(text = stringResource(R.string.skip_login),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.x_button),
                    modifier = Modifier
                        .padding(start = 121.dp)
                        .clickable {}
                )
                Text(text = stringResource(R.string.sing_up),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.x_button),
                    modifier = Modifier
                        .padding(end = 108.dp)
                        .clickable {}
                )
            }
        }
    }
}

