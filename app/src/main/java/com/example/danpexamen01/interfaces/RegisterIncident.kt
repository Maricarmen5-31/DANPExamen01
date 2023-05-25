package com.example.danpexamen01.interfaces

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterIncident(navController: NavController) {
    Scaffold(
        topBar = { CustomTopAppBar(
            navController = navController,
            title = "Registro de Asistentes",
            showBackIcon = true
        )},
        content = {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val nombres = remember {
                    mutableStateOf("")
                }

                val fecha = remember {
                    mutableStateOf("")
                }

                val tipoIncidente = remember {
                    mutableStateOf("")
                }

                val descripcion= remember {
                    mutableStateOf("")
                }

                val ubicacion= remember {
                    mutableStateOf("")
                }

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    text = "Registro de Incidentes",
                    style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                )

                Spacer(modifier = Modifier.height(30.dp))

                TextField(
                    label = { Text(text = "Nombre del incidente") },
                    value = nombres.value,
                    onValueChange = { nombres.value = it }
                )
                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Fecha") },
                    value = fecha.value,
                    onValueChange = { fecha.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Tipo de Incidente") },
                    value = tipoIncidente.value,
                    onValueChange = { tipoIncidente.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Ubicacion") },
                    value = ubicacion.value,
                    onValueChange = { ubicacion.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Descripcion") },
                    value = descripcion.value,
                    onValueChange = { descripcion.value = it }
                )

                Spacer(modifier = Modifier.height(30.dp))

                /*Text(
                    text = "Fecha Actual: ${fecha.value}",
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))*/

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                                  //
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Registrar Incidente")
                    }
                }
            }
        }
    )
}