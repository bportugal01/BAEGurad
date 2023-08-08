package com.example.baeguard.view


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baeguard.R



@ExperimentalMaterial3Api
@Composable
fun PerfilScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorProfile))
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize().padding(16.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(15.dp)
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                // Ícone de pessoa
                Icon(
                    painter = painterResource(id = R.drawable.baseline_person_outline_24),
                    contentDescription = "Ícone de Pessoa",
                    tint = Color.Blue,
                    modifier = Modifier.size(60.dp),

                    )

                // Espaço entre o ícone e as informações
                Spacer(modifier = Modifier.width(16.dp))

                // Informações do cliente
                Column(
                    verticalArrangement = Arrangement.Center // Centralizar verticalmente
                ) {

                    Text(
                        text = "Nome do Cliente",
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "cliente@exemplo.com",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Número do Cliente",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Column(
                modifier = Modifier.padding(0.dp)
            ) {
                Spacer(modifier = Modifier.width(56.dp))


                Divider(
                    color = Color(0xff232526).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .offset(
                            x = 0.dp,
                            y = 40.dp
                        )
                )
                // Editar Senha

                RowWithIcon(label = "Editar Senha", icon = Icons.Default.KeyboardArrowRight, "", navController)
                Spacer(modifier = Modifier.width(56.dp))


                Divider(
                    color = Color(0xff232526).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .offset(
                            x = 0.dp,
                            y = 40.dp
                        )
                )
                // Editar Email
                RowWithIcon(label = "Editar Email", icon = Icons.Default.KeyboardArrowRight, "", navController)
                Spacer(modifier = Modifier.width(56.dp))


                Divider(
                    color = Color(0xff232526).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .offset(
                            x = 0.dp,
                            y = 40.dp
                        )
                )
                // Editar Número
                RowWithIcon(label = "Editar Telefone", icon = Icons.Default.KeyboardArrowRight, "", navController)
                Spacer(modifier = Modifier.width(56.dp))


                Divider(
                    color = Color(0xff232526).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .offset(
                            x = 0.dp,
                            y = 40.dp
                        )
                )
                // Deletar Conta
                RowWithIcon(label = "Deletar Conta", icon = Icons.Default.KeyboardArrowRight, "tela_login", navController)
            }

        }

    }
}

@Composable
fun RowWithIcon(label: String, icon: ImageVector, navTitle: String, navController: NavController) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(navTitle)
            }
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 4.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = rememberVectorPainter(image = icon),
                contentDescription = "Ícone",
                tint = Color.Black
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    PerfilScreen(navController = rememberNavController())
}

