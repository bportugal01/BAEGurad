package com.example.baeguard.view


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baeguard.R


@Composable
fun HomeScreen(navController: NavController) {

    @Composable
    fun StatusCard(status: String, temperature: String, humidity: String, environment: String) {

            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(6.dp),
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xffe05950), Color(0xffffb74d))
                        )
                    )
                    .clickable { },
                elevation = 4.dp,
                backgroundColor = Color.White,
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
                            text = "Status: $status",
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
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        /*   Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = "Temperature",
                        tint = Color.Gray
                    )*/
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Temperature: $temperature",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        /*  Icon(
                      painter = painterResource(R.drawable.humidade),
                      contentDescription = stringResource(id = R.string.image1_content_description),
                      tint = Color.Gray
                  )*/
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Humidity: $humidity",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )
                    }
                }

        }
        Spacer(modifier = Modifier.width(600.dp))
    }

    // Classe de dados para simular os dados
    data class StatusData(val status: String, val temperature: String, val humidity: String, val environment: String)

    // Exemplo de uso
    val statusList = listOf(
        StatusData("Ok!", "20°C", "50%", "Living Room"),
        StatusData("Ok!", "27°C", "20%", "Living Room"),
        StatusData("Ok!", "29°C", "30%", "Living Room"),
        StatusData("Ok!", "25°C", "10%", "Living Room"),
        StatusData("Ok!", "27°C", "60%", "Living Room"),
        StatusData("Ok!", "25°C", "90%", "Living Room"),
        StatusData("Ok!", "25°C", "60%", "Living Room"),

    )

    // Função com LazyColumn que exibe os cards
    @Composable
    fun StatusCardList(statusList: List<StatusData>) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xffe05950), Color(0xffffb74d))
                    )
                )

        ) {
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