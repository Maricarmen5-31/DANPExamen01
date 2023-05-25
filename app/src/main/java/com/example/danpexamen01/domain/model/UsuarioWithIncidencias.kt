package com.example.danpexamen01.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class UsuarioWithIncidencias(
    @Embedded
    val usuarioEntity : UsuarioEntity,
    @Relation(
        parentColumn = "correoId",
        entityColumn = "usuarioCreatorId"
    )
    val incidencias : List<IncidenciaEntity>
)