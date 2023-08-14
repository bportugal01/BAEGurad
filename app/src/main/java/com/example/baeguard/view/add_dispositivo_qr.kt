package com.example.baeguard.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.baeguard.R

@Composable
fun Add_DispoScreen_Qr(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Device",
            color = Color(0xffe7e0cf),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .requiredWidth(width = 298.dp)
                .requiredHeight(height = 50.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre o texto e a imagem

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Exibir a imagem do código QR
            Image(
                painter = painterResource(id = R.drawable.image_3), // Substitua pelo recurso do seu código QR
                contentDescription = null, // Descrição de conteúdo (pode ser nula)
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), // Ajuste a altura conforme necessário
                contentScale = ContentScale.Fit // Ajusta o dimensionamento da imagem
            )
            Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre o texto e a imagem
            Text(
                text = "Scan this QR Code with the camera of your dispositive",
                color = Color(0xffe7e0cf),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),

                modifier = Modifier.requiredWidth(width = 291.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            androidx.compose.material.Button(
                onClick = { navController.navigate("home") },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xffe05950),
                    contentColor = Color(0xffffb74d),
                    disabledBackgroundColor = Color(0xffe05950),
                    disabledContentColor = Color(0xffffb74d)
                ),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                modifier = Modifier
                    .requiredWidth(width = 309.dp)
                    .requiredHeight(height = 44.dp)
                    .background(
                        shape = RoundedCornerShape(6.dp),
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xffe05950), Color(0xffffb74d))
                        )
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .requiredWidth(width = 309.dp)
                        .requiredHeight(height = 44.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_close_24),
                        contentDescription = null // You can add a proper content description here
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Cancelar")

                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    val navController = rememberNavController() // Declare e inicialize a variável navController
    Add_DispoScreen_Qr(navController)
}