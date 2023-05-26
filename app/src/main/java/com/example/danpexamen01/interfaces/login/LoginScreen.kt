package com.example.danpexamen01.interfaces.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.danpexamen01.core.Constantes
import com.example.danpexamen01.interfaces.ViewModel
import com.example.danpexamen01.ui.theme.PurpleGrey80
import com.example.danpexamen01.core.Constantes.Companion.CORREO
import com.example.danpexamen01.core.Constantes.Companion.CONTRASEÑA

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: ViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Signup Here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { navController.navigate("signup") },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = PurpleGrey80
            )
        )
    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var correo by remember { mutableStateOf(Constantes.NO_VALUE)}
        var contraseña by remember { mutableStateOf(Constantes.NO_VALUE)}

        Text(
            text = "MySecurityApp",
            style = TextStyle(fontSize = 60.sp, fontFamily = FontFamily.Cursive)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Login",
            style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.SansSerif)
        )

        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            label = { Text(CORREO) },
            value = correo,
            onValueChange = { correo = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            label = { Text(CONTRASEÑA) },
            value = contraseña,
            onValueChange = { contraseña = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    viewModel.getUsuario(correo)
                    if(viewModel.usuario.contraseña == contraseña)
                        navController.navigate("menu")
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        ClickableText(
            text = AnnotatedString("Forgot Password?"),
            onClick = { navController.navigate("forgot-password") },
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = PurpleGrey80
            )
        )
    }
}
