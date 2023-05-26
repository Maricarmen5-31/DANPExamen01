package com.example.danpexamen01.interfaces

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.danpexamen01.domain.model.IncidenciaEntity
import com.example.danpexamen01.domain.model.UsuarioWithIncidencias
import com.example.danpexamen01.ui.theme.Pink40
import com.example.danpexamen01.ui.theme.Purple80
import com.example.danpexamen01.ui.theme.PurpleGrey40
import com.example.danpexamen01.ui.theme.PurpleProfund
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Recomend(
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(
                navController = navController,
                title = "Recomendaciones",
                showBackIcon = true
            )},
            content = {

                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Recomendaciones y Consejos",
                        style = TextStyle(fontSize = 35.sp, fontFamily = FontFamily.Cursive)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .aspectRatio(4f)
                            .clip(RoundedCornerShape(30.dp)),
                        backgroundColor = PurpleProfund,
                        elevation = 10.dp,
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(com.example.danpexamen01.R.drawable.accidente_icon),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .size(90.dp)
                            )
                            Text(text = "En caso de robo",
                                     style = TextStyle(fontSize = 14.sp, color = Color.White))

                            Spacer(modifier = Modifier.weight(30f))

                            var show1 by rememberSaveable {
                                mutableStateOf(false)
                            }
                            var show2 by rememberSaveable {
                                mutableStateOf(false)
                            }

                            Button(
                                onClick = { show1 = true },
                                modifier = Modifier
                                    .padding(top = 0.dp)

                            ) {
                                Text(
                                    text = "Ver consejo",
                                    color = Color.White // Match button text color with card color
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            DialogConfirm1(show1, {show1 = false})
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .aspectRatio(4f)
                            .clip(RoundedCornerShape(30.dp)),
                        backgroundColor = PurpleProfund,
                        elevation = 10.dp,
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(com.example.danpexamen01.R.drawable.accidente_icon),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .size(90.dp)
                            )
                            Text(text = "Caso Accidente",
                                style = TextStyle(fontSize = 14.sp, color = Color.White))

                            Spacer(modifier = Modifier.weight(30f))

                            var show1 by rememberSaveable {
                                mutableStateOf(false)
                            }
                            var show2 by rememberSaveable {
                                mutableStateOf(false)
                            }

                            Button(
                                onClick = { show2 = true },
                                modifier = Modifier
                                    .padding(top = 0.dp)

                            ) {
                                Text(
                                    text = "Ver consejo",
                                    color = Color.White // Match button text color with card color
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            DialogConfirm2(show2, {show2 = false})
                        }
                    }
                }
            }
        )
    }
}
@Composable
fun DialogConfirm1(
    show1: Boolean,
    onConfirm: () -> Unit
) {
    if(show1) {
        AlertDialog(onDismissRequest = { onConfirm() },
            confirmButton = { TextButton(onClick = { onConfirm() }) {
                Text(text = "OK")
            }
            },
            title = { Text(text = "RECOMENDACIÓN") },
            text = { Text(text = "Si el robo acaba de ocurrir y el ladrón aún está presente, " +
                    "no intentes confrontarlo directamente. " +
                    "Busca un lugar seguro y llama a la policía inmediatamente.")})
    }
}
@Composable
fun DialogConfirm2(
    show2: Boolean,
    onConfirm: () -> Unit
) {
    if(show2) {
        AlertDialog(onDismissRequest = { onConfirm() },
            confirmButton = { TextButton(onClick = { onConfirm() }) {
                Text(text = "OK")
            }
            },
            title = { Text(text = "RECOMENDACIÓN") },
            text = { Text(text = "Proteger al herido y a nosotros mismos," +
                    " situándonos fuera de la zona de peligro.\n" +
                    "Avisar a los servicios de emergencia:  " +
                    "llamar al 225151 y la línea gratuita 0800-41241")})
    }
}

