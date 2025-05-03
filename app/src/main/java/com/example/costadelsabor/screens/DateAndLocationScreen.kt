package com.example.costadelsabor.screens

import android.app.TimePickerDialog
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.example.costadelsabor.ui.UiDateTextField
import com.example.costadelsabor.ui.UiLocationTextField
import com.example.costadelsabor.ui.UiTimeTextField
import com.example.costadelsabor.ui.UiButton
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
    val timeText = selectedTime?.let { calendar -> timeFormatter.format(calendar.time) } ?: ""

    var showLocationDialog by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf("") }
    val address = Address(street = "Street", city = "City", state = "State", zipCode = "ZipCode")

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

            Spacer(modifier = Modifier.padding(top = 47.dp))

            UiDateTextField(
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
            Spacer(modifier = Modifier.padding(17.dp))

            UiTimeTextField(
                timeText = timeText,
                onTimeClick = { showTimePicker = true }
            )

            if (showTimePicker) {
                val initialHour = selectedTime?.get(Calendar.HOUR_OF_DAY) ?: 13
                val initialMinute = selectedTime?.get(Calendar.MINUTE) ?: 0
                TimePickerDialog(
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

            Spacer(modifier = Modifier.padding(17.dp))

            UiLocationTextField(
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

            Spacer(modifier = Modifier.padding(44.dp))

            UiButton(
                onCLick = { /*TODO*/ },
                color = R.color.unfocIndicatorColor_log_page,
                title = stringResource(R.string.confirm)
            )
            Spacer(modifier = Modifier.padding(27.dp))
            Text(
                text = "Skip",
                fontSize = 15.sp,
                color = colorResource(id = R.color.x_button),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { }
            )
            Spacer(modifier = Modifier.padding(130.dp))
        }
    }
}

@Preview
@Composable
private fun DateAndLocationScreenPreview() {
    DateAndLocationScreen()
}