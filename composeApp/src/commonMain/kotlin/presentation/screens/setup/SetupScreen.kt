package presentation.screens.setup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SetupScreen(
    viewModel: SetupScreenViewModel = viewModel { SetupScreenViewModel() }
) {
    var raceType by remember { mutableStateOf(TextFieldValue("")) }
    var riderInterval by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Setup Race",
                        fontSize = 24.sp,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = raceType,
                    onValueChange = { raceType = it },
                    placeholder = { Text("Enter race type") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom =  16.dp),
                    label = {
                        Text("Enter race type")
                    }
                )

                OutlinedTextField(
                    value = riderInterval,
                    onValueChange = { riderInterval = it },
                    label = {
                        Text("Enter rider's interval")
                    },
                    placeholder = { Text("Enter rider's interval") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom =  16.dp),

                    )

                Button(
                    onClick = { /* TODO: Handle button click */ },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom= 16.dp)
                        .height(50.dp)
                ) {
                    Text(text = "Import riders csv", fontSize = 18.sp)
                }

                Button(
                    onClick = { /* TODO: Handle button click */ },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom= 16.dp)
                        .height(50.dp)
                ) {
                    Text(text = "Resume race csv", fontSize = 18.sp)
                }
            }
        }
    )
}