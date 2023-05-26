package com.example.danpexamen01.interfaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danpexamen01.interfaces.forgotPassword.ForgotPassword
import com.example.danpexamen01.interfaces.listaIncidentes.IncidenciaCard
import com.example.danpexamen01.interfaces.listaIncidentes.IncidentesScreen
import com.example.danpexamen01.interfaces.login.LoginPage
import com.example.danpexamen01.interfaces.login.LoginScreen
import com.example.danpexamen01.interfaces.registerIncident.RegisterIncidentScreen
import com.example.danpexamen01.ui.theme.DANPExamen01Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANPExamen01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenMain()
                }
            }
        }
    }
}




@Composable
fun ScreenMain(
    //viewModel: ViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()

    //val incidencias by viewModel.incidencias.toCollection()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("menu") { PrincipalMenu(navController = navController) }
        composable("signup") { LoginScreen(navController = navController) }
        composable("forgot-password") { ForgotPassword(navController = navController) }
        composable("registrar-incident") { RegisterIncidentScreen(navController = navController) }
        composable("listado_incident") { IncidentesScreen(navController = navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    DANPExamen01Theme {
        ScreenMain()
    }
}