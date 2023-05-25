package com.example.danpexamen01.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.danpexamen01.core.Constantes.Companion.USUARIO_TABLE

@Entity(tableName = USUARIO_TABLE)
data class UsuarioEntity (
    @PrimaryKey
    val correoId : String,
    val nombres : String,
    val apellidos : String,
    val contraseña : String
)