package com.example.baeguard.view

import android.annotation.SuppressLint
import android.renderscript.Sampler.Value
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baeguard.R
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun EdEmailScreen() {
    var value by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
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
            text = "Email",
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
        value = value,
        onValueChange = { value = it },
        label = { Text("Email Atual", color = Color.White) },
        modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffffe98a),
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                cursorColor = Color.White),
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Novo Email", color = Color.White) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffffe98a),
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                cursorColor = Color.White),
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Confirmar Email", color = Color.White) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
