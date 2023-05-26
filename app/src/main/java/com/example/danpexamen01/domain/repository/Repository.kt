package com.example.danpexamen01.domain.repository

import com.example.danpexamen01.domain.model.IncidenciaEntity
import com.example.danpexamen01.domain.model.UsuarioEntity
import com.example.danpexamen01.domain.model.UsuarioWithIncidencias
import kotlinx.coroutines.flow.Flow

typealias Usuarios = List<UsuarioEntity>
typealias Incidencias = List<IncidenciaEntity>

interface Repository {
    fun getAllUsuarios(): Flow<Usuarios>
    fun addUsuario(usuarioEntity: UsuarioEntity)
    fun getUsuario(correoId: String): UsuarioEntity
    fun updateUsuario(usuarioEntity: UsuarioEntity)

    fun getAllIncidencias(): Flow<Incidencias>
    fun addIncidencia(incidenciaEntity: IncidenciaEntity)
    fun getIncidencia(incidenciaId: Int): IncidenciaEntity
    fun updateIncidencia(incidenciaEntity: IncidenciaEntity)

    //fun getUsuarioWithIncidencias(): Flow<UsuarioWithIncidencias>

}