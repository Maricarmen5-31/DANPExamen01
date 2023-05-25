package com.example.danpexamen01.interfaces

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.danpexamen01.data.repository.Incidencias
import com.example.danpexamen01.domain.model.UsuarioWithIncidencias


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaIncident(
    navController: NavController,
    //incidencias: Incidencias

   ) {

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(
                navController = navController,
                title = "Mis incidencias",
                showBackIcon = true
            )},
            content = {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn {

                       /* items(incidencias){incidencia->
                            IncidenciaCard(
                                incidenciaEntity = incidencia
                            )
                        }*/
                    }
                }
            }
        )
    }
}