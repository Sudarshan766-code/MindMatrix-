package com.example.tipcalculator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

@Composable
fun TipCalculatorScreen() {

    var billInput by rememberSaveable { mutableStateOf("") }
    var peopleInput by rememberSaveable { mutableStateOf("") }
    var tipPercent by rememberSaveable { mutableStateOf(15f) }
    var roundUp by rememberSaveable { mutableStateOf(false) }
    var result by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Tip Calculator", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = billInput,
            onValueChange = { billInput = it },
            label = { Text("Bill Amount") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = peopleInput,
            onValueChange = { peopleInput = it },
            label = { Text("Number of People") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tip Percentage: ${tipPercent.toInt()}%")

        Slider(
            value = tipPercent,
            onValueChange = { tipPercent = it },
            valueRange = 0f..30f
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Round Up Tip")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            val bill = billInput.toDoubleOrNull()
            val people = peopleInput.toIntOrNull()

            if (bill == null || bill <= 0) {
                errorMessage = "Enter valid bill amount."
                result = ""
                return@Button
            }

            if (people == null || people < 1) {
                errorMessage = "Number of people must be at least 1."
                result = ""
                return@Button
            }

            errorMessage = ""

            var tip = bill * tipPercent / 100
            if (roundUp) {
                tip = ceil(tip)
            }

            val totalPerPerson = (bill + tip) / people
            result = "Each Person Pays: ₹%.2f".format(totalPerPerson)

        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, color = Color.Red)
        }

        if (result.isNotEmpty()) {
            Text(result, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
