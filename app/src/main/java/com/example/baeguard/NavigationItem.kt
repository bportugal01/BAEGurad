package com.example.baeguard

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.baseline_home_24, "Home")
    object Perfil : NavigationItem("perfil", R.drawable.baseline_person_24, "Perfil")
    object Historico : NavigationItem("historico", R.drawable.baseline_history_24, "Historico")

}