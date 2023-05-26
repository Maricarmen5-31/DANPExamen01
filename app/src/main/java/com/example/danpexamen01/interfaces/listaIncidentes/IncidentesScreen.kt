package com.example.danpexamen01.interfaces.listaIncidentes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.danpexamen01.interfaces.CustomTopAppBar
import com.example.danpexamen01.interfaces.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IncidentesScreen(
    viewModel: ViewModel = hiltViewModel(),
    navController: NavController
) {
    val incidencias by viewModel.incidencias.collectAsState(initial = emptyList())

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(
                navController = navController,
                title = "Mis incidencias",
                showBackIcon = true
            )
            },
            content = {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        items(incidencias){
                                incidencia->
                            IncidenciaCard(
                                incidencia = incidencia,
                                navController = navController
                            )
                        }
                    }
                }
            }
        )
    }
}