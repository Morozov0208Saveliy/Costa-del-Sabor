package com.example.costadelsabor.screens

import android.app.TimePickerDialog
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.costadelsabor.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DateAndLocationScreen() {
    val context = LocalContext.current

    var showDateDialog by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    val dateText = selectedDate?.let { millis -> dateFormatter.format(Date(millis)) } ?: ""

    var showTimePicker by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf<Calendar?>(null) }
    val timeFormatter = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    val timeText = selectedTime?.let { calendar -> timeFormatter.format(calendar.time) } ?: "13:00"

    var showLocationDialog by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf("") }
    val address = Address(street = "Street", city = "City", state = "State", zipCode = "ZipCode")

    //(можно расширить)
    val locations = listOf(
        "Main Office",
        "Downtown",
        "Suburban Branch",
        "${address.street}, ${address.city}"
    )

    // Состояние для диалога выбора локации
    var showAddressDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "", style = MaterialTheme.typography.bodySmall) },
                navigationIcon = {
                    IconButton(onClick = { /* Действие при нажатии назад */ }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Date and Location",
                fontSize = 28.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            Text(
                text = "Please provide your event date,\npreferred time and location",
                maxLines = 2,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.OR_page_LogIn)
            )

            DateTextField(
                dateText = dateText,
                onDateClick = {
                    showDateDialog = true
                    Log.d("DateAndLocationScreen", "DateTextField clicked")
                }
            )

            if (showDateDialog) {
                val datePickerState = rememberDatePickerState(
                    initialSelectedDateMillis = selectedDate
                )
                DatePickerDialog(
                    onDismissRequest = { showDateDialog = false },
                    confirmButton = {
                        TextButton(onClick = {
                            selectedDate = datePickerState.selectedDateMillis
                            showDateDialog = false
                        }) { Text("OK") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDateDialog = false }) { Text("Cancel") }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }

            TimeTextField(
                timeText = timeText,
                onTimeClick = { showTimePicker = true }
            )

            if (showTimePicker) {
                val initialHour = selectedTime?.get(Calendar.HOUR_OF_DAY) ?: 13
                val initialMinute = selectedTime?.get(Calendar.MINUTE) ?: 0
                TimePickerDialog( //цвет поменять
                    context,
                    { _, hourOfDay, minute ->
                        val cal = Calendar.getInstance().apply {
                            set(Calendar.HOUR_OF_DAY, hourOfDay)
                            set(Calendar.MINUTE, minute)
                        }
                        selectedTime = cal
                    },
                    initialHour,
                    initialMinute,
                    true
                ).apply { show() }
                showTimePicker = false
            }

            LocationTextField(
                selectedLocation = selectedLocation,
                onLocationClick = { showAddressDialog = true }
            )

            if (showAddressDialog) {
                AlertDialog(
                    onDismissRequest = { showAddressDialog = false },
                    title = { Text(text = "Select Location") },
                    text = {
                        Column {
                            locations.forEach { location ->
                                Text(
                                    text = location,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            selectedLocation = location
                                            showAddressDialog = false
                                        }
                                        .padding(8.dp)
                                )
                            }
                        }
                    },
                    confirmButton = {},
                    dismissButton = {
                        TextButton(onClick = { showAddressDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }

            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.unfocIndicatorColor_log_page)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 63.dp, end = 70.dp, top = 44.dp)
            ) {
                Text(
                    text = stringResource(R.string.sing_up),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Text(
                text = "Skip",
                fontSize = 15.sp,
                color = colorResource(id = R.color.x_button),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 27.dp, bottom = 130.dp)
                    .clickable { }
            )
        }
    }
}

@Composable
fun DateTextField(
    dateText: String,
    onDateClick: () -> Unit
) {
    OutlinedTextField(//Должна быть колонна
        value = dateText,
        onValueChange = {},
        enabled = false,
        readOnly = true,
        label = { Text("Date") },
        trailingIcon = {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.DateRange,
                contentDescription = "Open Date"
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.teal_700),
            unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDateClick()
            Log.d("DateAndLocationScreen", "Click clicked")
            }
            .padding(start = 19.dp, end = 4.dp, top = 47.dp)
    )
}

@Composable
fun TimeTextField(// поменять цвет пикера в диа
    timeText: String,
    onTimeClick: () -> Unit
) {
    OutlinedTextField(
        value = timeText,
        onValueChange = {},
        enabled = false,
        readOnly = true,
        label = { Text("Time") },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.access_time_24),
                contentDescription = "Time"
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.teal_700),
            unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onTimeClick() }
            .padding(start = 19.dp, end = 4.dp, top = 17.dp)
    )
}

@Composable
fun LocationTextField(
    selectedLocation: String,
    onLocationClick: () -> Unit
) {
    OutlinedTextField(
        value = selectedLocation,
        onValueChange = {},
        readOnly = true,
        label = { Text("Location") },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Choose location"
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.teal_700),
            unfocusedBorderColor = colorResource(id = R.color.unfocIndicatorColor_log_page)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onLocationClick() }
            .padding(start = 19.dp, end = 4.dp, top = 18.dp)
    )
}