package com.example.baeguard

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baeguard.ui.theme.BaeguardTheme
import com.example.baeguard.view.PerfilScreen
import com.example.baeguard.view.tela_cadastro
import com.example.baeguard.view.tela_login

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaeguardTheme {

                window.statusBarColor=getColor(R.color.black)
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "tela_login"){
                    composable(
                        route = "tela_login"
                    ){
                        tela_login(navController)
                    }

                    composable(
                        route = "tela_cadastro"
                    ){
                        tela_cadastro(navController)
                    }
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable("perfil") {
                        PerfilScreen(navController)
                    }


                }

            }
        }
    }




}
