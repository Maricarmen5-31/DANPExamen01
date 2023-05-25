package com.example.danpexamen01.domain.repository

import com.example.danpexamen01.domain.model.IncidenciaEntity
import com.example.danpexamen01.domain.model.UsuarioEntity
import com.example.danpexamen01.domain.model.UsuarioWithIncidencias

interface Repository {
    suspend fun getAllUsuarios(): List<UsuarioEntity>
    suspend fun addUsuario(usuarioEntity: UsuarioEntity)
    suspend fun getUsuario(correoId: String): UsuarioEntity
    suspend fun updateUsuario(usuarioEntity: UsuarioEntity)

    suspend fun getAllIncidencias(): List<IncidenciaEntity>
    suspend fun addIncidencia(incidenciaEntity: IncidenciaEntity)
    suspend fun getIncidencia(incidenciaId: Int): IncidenciaEntity
    suspend fun updateIncidencia(incidenciaEntity: IncidenciaEntity)

    suspend fun getUsuarioWithIncidencias(): List<UsuarioWithIncidencias>

}