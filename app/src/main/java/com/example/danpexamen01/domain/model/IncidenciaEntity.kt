package com.example.danpexamen01.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.danpexamen01.core.Constantes.Companion.INCIDENCIA_TABLE
import org.jetbrains.annotations.NotNull

@Entity(tableName = INCIDENCIA_TABLE)
data class IncidenciaEntity(
    @PrimaryKey(autoGenerate = true)
    val incidenciaId : Int,
    val usuarioCreatorId : String,
    @NotNull
    val nombre : String,
    val descripcion : String,
    val categoria : String,
    val fecha : String,
    val hora : String,
    val provincia : String,
    val distrito : String,
    val imagen : String
) {

}