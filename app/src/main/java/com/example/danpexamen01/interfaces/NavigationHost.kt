package com.example.danpexamen01.interfaces

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danpexamen01.interfaces.menu.ItemsMenu.*
import com.example.danpexamen01.interfaces.registerIncident.RegisterIncident
import com.example.danpexamen01.interfaces.usuario.Usuario

@Composable
fun NavigationHost(navController: NavHostController){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Pantalla2.ruta){
        composable(Pantalla2.ruta){
            ListaIncident(navController = navController)
        }
        
        composable(Pantalla1.ruta){
            Usuario()
        }

        composable(Pantalla3.ruta){
            RegisterIncident(navController = navController)
        }
    }

}