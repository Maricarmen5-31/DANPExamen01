package com.example.danpexamen01.interfaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danpexamen01.domain.model.IncidenciaEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IncidenciaCard(
    navController: NavController,
    incidenciaEntity: IncidenciaEntity

    ){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            
        }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column() {
                Text(incidenciaEntity.nombre)
                Text(text = incidenciaEntity.distrito)
                Text(text = incidenciaEntity.fecha)
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
           
        }
    }

}