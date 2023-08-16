package com.example.baeguard.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baeguard.R

data class FireInfo(
    val day: String,
    val temperature: String,
    val humidity: String,
    val co2Detection: String,
    val gasType: String
)

val fakeFireData = listOf(
    FireInfo("Segunda-feira", "28°C", "50%", "Baixa", "GLP"),
    FireInfo("Terça-feira", "27°C", "48%", "Moderada", "Natural"),
    FireInfo("Quarta-feira", "30°C", "55%", "Alta", "GLP"),
    FireInfo("Quinta-feira", "29°C", "52%", "Baixa", "Natural"),
    FireInfo("Sexta-feira", "31°C", "58%", "Moderada", "GLP"),
    FireInfo("Sábado", "26°C", "47%", "Alta", "Natural"),
    FireInfo("Domingo", "25°C", "45%", "Baixa", "GLP")
)

@Composable
fun FireInfoCard(fireInfo: FireInfo) {
    androidx.compose.material.Card(
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
        backgroundColor = Color(0xffe7e0cf),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = fireInfo.day,style = androidx.compose.material.MaterialTheme.typography.h6,color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temperatura: ${fireInfo.temperature}", color = Color.Gray, style = androidx.compose.material.MaterialTheme.typography.body1,)
            Text(text = "Umidade: ${fireInfo.humidity}", color = Color.Gray, style = androidx.compose.material.MaterialTheme.typography.body1,)
            Text(text = "Detecção de CO2: ${fireInfo.co2Detection}",  color = Color.Gray, style = androidx.compose.material.MaterialTheme.typography.body1,)
            Text(text = "Tipo de Gás: ${fireInfo.gasType}", color = Color.Gray, style = androidx.compose.material.MaterialTheme.typography.body1,)
        }
    }
}
@Composable
fun HistoricoScreen() {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "History",
                color = Color(0xffe7e0cf),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(16.dp) // Adicione o padding desejado aqui
                    .fillMaxWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
        items(fakeFireData) { fireInfo ->
            FireInfoCard(fireInfo = fireInfo)
        }
    }
}


@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            HistoricoScreen()
        }
    }
}