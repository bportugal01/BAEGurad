package com.example.baeguard.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EdNomeScreen(onBackPressed: () -> Unit = {}) {
    var currentName by remember { mutableStateOf("") }
    var newName by remember { mutableStateOf("") }
    var confirmName by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Change Name",
            color = Color(0xFFFFFFFF),
            style = TextStyle(
                fontSize = 50.sp)
        )


        Spacer(modifier = Modifier.height(75.dp))
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffffe98a),
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                cursorColor = Color.White),
            value = currentName,
            onValueChange = { currentName = it },
            label = { Text("Nome atual", color = Color.White) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffffe98a),
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                cursorColor = Color.White),
            value = newName,
            onValueChange = { newName = it },
            label = { Text("Novo Nome", color = Color.White) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffffe98a),
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                cursorColor = Color.White),
            value = confirmName,
            onValueChange = { confirmName = it },
            label = { Text("Confirmar novo Nome", color = Color.White) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = { },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffe05950) ,contentColor = Color(0xffffb74d), disabledBackgroundColor = Color(0xffe05950), disabledContentColor =  Color(0xffffb74d)),
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
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .requiredWidth(width = 309.dp)
                    .requiredHeight(height = 44.dp)
            ) {
                Text(
                    text = "Change Name",
                    color = Color(0xFFFFFFFF),
                    style = TextStyle(
                        fontSize = 16.sp)
                )

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.clickable (onClick = onBackPressed)
        ) {
            IconButton(
                onClick = onBackPressed,

                modifier = Modifier
                    .clip(shape = RoundedCornerShape(6.dp))
                    .requiredWidth(width = 309.dp)
                    .requiredHeight(height = 44.dp)
                    .border(
                        border = BorderStroke(2.dp, Color(0xFFFFFFFF)),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(
                        horizontal = 108.dp,
                        vertical = 12.dp
                    )

            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Fechar",
                        tint = Color(0xFFFFFFFF)
                    )
                    Text(
                        text = "Cancel",
                        color = Color(0xFFFFFFFF),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }

    }
}