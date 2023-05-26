package com.example.danpexamen01.interfaces.register

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.danpexamen01.core.Constantes
import com.example.danpexamen01.core.Constantes.Companion.REGISTER_SCREEN
import com.example.danpexamen01.core.Constantes.Companion.CORREO
import com.example.danpexamen01.core.Constantes.Companion.NOMBRE
import com.example.danpexamen01.core.Constantes.Companion.APELLIDO
import com.example.danpexamen01.core.Constantes.Companion.CONTRASEÑA
import com.example.danpexamen01.domain.model.UsuarioEntity
import com.example.danpexamen01.interfaces.CustomTopAppBar
import com.example.danpexamen01.interfaces.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterScreen(
    viewModel: ViewModel = hiltViewModel(),
    navController: NavController,
) {
    Scaffold(
        topBar = { CustomTopAppBar(
            navController = navController,
            title = "SignUp",
            showBackIcon = true
        )
        },
        content = {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var correo by remember { mutableStateOf(Constantes.NO_VALUE)}
                var nombre by remember { mutableStateOf(Constantes.NO_VALUE)}
                var apellido by remember { mutableStateOf(Constantes.NO_VALUE)}
                var contraseña by remember { mutableStateOf(Constantes.NO_VALUE)}

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    text = REGISTER_SCREEN,
                    style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(CORREO) },
                    value = correo,
                    onValueChange = { correo = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(NOMBRE) },
                    value = nombre,
                    onValueChange = { nombre = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(APELLIDO) },
                    value = apellido,
                    onValueChange = { apellido = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(CONTRASEÑA) },
                    value = contraseña,
                    onValueChange = { contraseña = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            val usuario = UsuarioEntity(correo, nombre, apellido, contraseña)
                            viewModel.addUsuario(usuario)
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = REGISTER_SCREEN)
                    }
                }
            }
        }
    )
}