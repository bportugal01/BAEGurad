package com.example.baeguard.view


import TopBar
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baeguard.R



@ExperimentalMaterial3Api
@Composable
fun PerfilScreen(navController: NavController) {

    @Composable
    fun RowWithIcon(label: String, icon: ImageVector) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier
                .padding(top = 8.dp)



        ) {

            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
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
                    tint = Color.White,
                    modifier = Modifier.align(CenterEnd)
                )
            }


        }
    }

    @Composable
    fun Perfil1(modifier: Modifier = Modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.colorProfile))
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(6.dp))

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logov31),
                        contentDescription = stringResource(id = R.string.logov31_content_description),
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Nome do Cliente",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "cliente@exemplo.com",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("ed_senha") }
                    .padding(16.dp)
                    .height(40.dp)


            ) {
                RowWithIcon(label = "Editar Senha", icon = Icons.Default.KeyboardArrowRight)
                Divider(
                    color = Color(0xFFFFFFFF).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("ed_email") }
                    .padding(16.dp)
                    .height(40.dp)

            ) {
                RowWithIcon(label = "Editar Email", icon = Icons.Default.KeyboardArrowRight)
                Divider(
                    color = Color(0xFFFFFFFF).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("ed_nome") }
                    .padding(16.dp)
                    .height(40.dp)

            ) {
                RowWithIcon(label = "Editar Nome", icon = Icons.Default.KeyboardArrowRight)
                Divider(
                    color = Color(0xFFFAF7F7).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("del_conta") }
                    .padding(16.dp)
                    .height(40.dp)


            ) {
                RowWithIcon(label = "Deletar Conta", icon = Icons.Default.Delete)
                Divider(
                    color = Color(0xFFFFFFFF).copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )
            }
        }
    }

        Perfil1()
    }



