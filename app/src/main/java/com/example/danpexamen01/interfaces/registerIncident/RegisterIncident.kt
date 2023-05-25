package com.example.danpexamen01.interfaces.registerIncident

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.danpexamen01.interfaces.CustomTopAppBar
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterIncident(navController: NavController) {

    val calendarState = rememberSheetState()

    Scaffold(
        topBar = { CustomTopAppBar(
            navController = navController,
            title = "Registro de Asistentes",
            showBackIcon = true
        )
        },
        content = {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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

                val descripcion = remember {
                    mutableStateOf("")
                }

                val ubicacion = remember {
                    mutableStateOf("")
                }


                CalendarDialog(
                    state = calendarState,
                    selection = CalendarSelection.Date { date ->
                        fecha.value = "$date"
                    }
                )

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

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextField(
                        modifier = Modifier.width(174.dp),
                        label = { Text(text = "Fecha") },
                        value = fecha.value,
                        onValueChange = { fecha.value = it }
                    )
                    Button(
                        onClick = { calendarState.show() },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .padding(15.dp, 0.dp, 0.dp, 0.dp)
                            .height(40.dp)
                            .width(90.dp)

                    ) {
                        Text(text = "Ver")
                    }
                }
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

                var show by rememberSaveable {
                    mutableStateOf(false)
                }

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                                  show = true
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Registrar Incidente")
                    }
                }

                DialogConfirm(show, {show = false}, {Log.i("accion", "click")})
            }
        }
    )
}

@Composable
fun DialogConfirm(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if(show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            confirmButton = { TextButton(onClick = { onConfirm() }) {
                Text(text = "Aceptar")
            }},
            dismissButton = { TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancelar")
            }},
            title = { Text(text = "CONFIRMACION DE REGISTRO") },
            text = { Text(text = "¿Estas seguro de registrar esta incidencia?")})
    }
}

