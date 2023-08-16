package com.example.baeguard.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.baeguard.R


@Composable
fun HomeScreen(navController: NavController) {

    @Composable
    fun StatusCard(status: String, temperature: String, humidity: String, environment: String) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(
                        shape = RoundedCornerShape(6.dp),
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xffe05950), Color(0xffffb74d))
                        )
                    )
            ) {

            Card(
                border = BorderStroke(2.dp, Color(0xffe05950)),
                modifier = Modifier
                    .padding(16.dp)
                    .border(
                        border = BorderStroke(2.dp, Color(0xffe05950)),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .fillMaxWidth()
                    .clickable { navController.navigate("home_delt") },
                elevation = 4.dp,
                backgroundColor = Color(0xffe7e0cf),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Status:",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Humidity",
                                tint = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "$environment",
                                style = MaterialTheme.typography.body1,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.Center){
                        Text(
                            text = "$status",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                          Icon(
                              painter = painterResource(R.drawable.temperatura),
                              contentDescription = stringResource(id = R.string.temperatura_content_description),
                              tint = Color.Gray,
                              modifier = Modifier.height(30.dp)
                    )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Temperature: $temperature",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 16.dp)) {
                        Icon(
                      painter = painterResource(R.drawable.ahumidade),
                      contentDescription = stringResource(id = R.string.humidade_content_description),
                      tint = Color.Gray,
                            modifier = Modifier.height(20.dp)
                  )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Humidity: $humidity",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }

    // Classe de dados para simular os dados
    data class StatusData(val status: String, val temperature: String, val humidity: String, val environment: String)

    // Exemplo de uso
    val statusList = listOf(
        StatusData("CO2 DETECTED!", "20°C", "50%", "Living Room"),
        StatusData("All Right!", "27°C", "20%", "Living Room"),
        StatusData("All Right!", "29°C", "30%", "Living Room"),


    )

    // Função com LazyColumn que exibe os cards
    @Composable
    fun StatusCardList(statusList: List<StatusData>) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(colorResource(id = R.color.colorProfile), colorResource(id = R.color.colorProfile))
                    )
                )

        ) {
            Column (modifier = Modifier.background(color =Color(0xffe05950) ).fillMaxWidth()) {

            }

            LazyColumn {
                items(statusList) { statusData ->
                    StatusCard(
                        status = statusData.status,
                        temperature = statusData.temperature,
                        humidity = statusData.humidity,
                        environment = statusData.environment
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        StatusCardList(statusList)

        FloatingActionButton(
            backgroundColor = colorResource(id = R.color.colorPrimary),
            onClick = { navController.navigate("add_dispo") },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)

        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White
            )
        }
    }
}