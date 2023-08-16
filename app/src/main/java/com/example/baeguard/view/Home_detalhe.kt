package com.example.baeguard.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baeguard.R
import com.example.baeguard.ui.theme.c2
import com.example.baeguard.ui.theme.c3


@Composable
fun HomeDetalhe(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffe7e0cf)
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(
                            color = Color(0xff232526),
                            shape = RoundedCornerShape(8.dp) // Ajuste o raio de acordo com suas preferências
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_camera_alt_24), // Substitua pelo ID do ícone da câmera
                        contentDescription = "Camera Icon",
                        tint = Color.Black, // Cor do ícone
                        modifier = Modifier.size(48.dp)
                    )
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 316.dp)
                        .requiredHeight(height = 50.dp)
                ) {
                    Text(
                        text = "Sala",
                        color = Color(0xff232526),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_delete_24),
                        contentDescription = "delete",
                        tint = Color(0xff1c1b1f),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 315.dp, y = 0.dp)
                            .size(40.dp)
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 0.dp), // Espaçamento vertical
                    horizontalArrangement = Arrangement.Center // Centralizar na horizontal
                ) {
                    CardGradiente3(60)
                    Spacer(modifier = Modifier.width(10.dp)) // Espaçamento horizontal
                    CardGradiente2(25.0)
                    Spacer(modifier = Modifier.width(16.dp)) // Espaçamento horizontal
                }
            }

            item {
                CardGradiente("C02 DETECTADO")
            }
        }
    }
}



@Composable
fun CardGradiente3(humidity: Int) {
    val c4 = Color(0xFF298DDD)
    val c5 = Color(0xFFF3E2B9)

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(180.dp)
            .padding(0.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(c5, c4)
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .align(Alignment.Center)
            ) {
                Text(
                    text = "Umidade   ",
                    color = Color(0xff232526),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .requiredWidth(width = 150.dp)
                        .requiredHeight(height = 45.dp)
                )
                Text(
                    text = "$humidity%",
                    color = Color(0xff232526),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
            }
        }
    }
}



@Composable
fun CardGradiente2(temperature: Double) {
    val c4 = Color(0xFFFF5722)
    val c5 = Color(0xFFFFEB3B)

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(180.dp)
            .padding(0.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(c5, c4)
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .align(Alignment.Center)
            ) {
                Text(
                    text = "Temperatura",
                    color = Color(0xff232526),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .requiredWidth(width = 150.dp)
                        .requiredHeight(height = 45.dp)
                )


                Text(
                    text = "$temperature °C",
                    color = Color(0xff232526),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
            }
        }
    }
}



@Composable
fun CardGradiente(status: String) {
    val c2 = Color(0xff61ff5c)
    val c3 = Color(0xffffe98a)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Card(
            modifier = Modifier
                .width(350.dp)
                .height(200.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(c3, c2)
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = "Status",
                        color = Color(0xff232526),
                        style = TextStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .requiredWidth(width = 200.dp)
                            .requiredHeight(height = 45.dp)
                    )
                    Text(
                        text = status,
                        color = Color(0xff232526),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    )
                }
            }
        }
    }
}