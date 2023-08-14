package com.example.baeguard.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.baeguard.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EdSenhaScreen() {

                var currentPassword by remember { mutableStateOf("") }
                var newPassword by remember { mutableStateOf("") }
                var confirmPassword by remember { mutableStateOf("") }



                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Change",
                                color = Color(0xFFFFFFFF),
                                style = TextStyle(
                                    fontSize = 50.sp)
                            )
                            Text(
                                text = "Password",
                                color = Color(0xFFFFFFFF),
                                style = TextStyle(
                                    fontSize = 50.sp, textAlign = TextAlign.Right)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            OutlinedTextField(
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(0xffffe98a),
                                    unfocusedBorderColor = Color.White,
                                    focusedLabelColor = Color.White,
                                    cursorColor = Color.White),
                                value = currentPassword,
                                onValueChange = { currentPassword = it },
                                label = { Text("Senha atual", color = Color.White) },
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
                                value = newPassword,
                                onValueChange = { newPassword = it },
                                label = { Text("Nova senha", color = Color.White) },
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
                                value = confirmPassword,
                                onValueChange = { confirmPassword = it },
                                label = { Text("Confirmar nova senha", color = Color.White) },
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
                                        text = "Change Password",
                                        color = Color(0xFFFFFFFF),
                                        style = TextStyle(
                                            fontSize = 16.sp)
                                    )
                                }
                            }
                        }
                    }


    @Preview
    @Composable
    fun PreviewEditPasswordScreen() {
        EdSenhaScreen()
    }

