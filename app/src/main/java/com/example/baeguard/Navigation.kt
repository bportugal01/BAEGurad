package com.example.baeguard

// Navigation.kt
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Perfil : Screen("perfil")
    object Historico : Screen("historico")
}