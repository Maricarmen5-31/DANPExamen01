package com.example.danpexamen01.interfaces.menu

import com.example.danpexamen01.R

sealed class ItemsMenu(
    val icon: Int,
    val title: String,
    val ruta: String,

){
    object Pantalla1: ItemsMenu(R.drawable.user, "Usuario", "pantalla1")
    object Pantalla2: ItemsMenu(R.drawable.menu, "Menu","pantalla2")
    object Pantalla3: ItemsMenu(R.drawable.register_incident, "registerIncident", "pantalla3")
}
