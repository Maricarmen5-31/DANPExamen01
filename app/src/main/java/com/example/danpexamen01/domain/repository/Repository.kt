package com.example.danpexamen01.domain.repository

import com.example.danpexamen01.domain.model.IncidenciaEntity
import com.example.danpexamen01.domain.model.UsuarioEntity
import com.example.danpexamen01.domain.model.UsuarioWithIncidencias

interface Repository {
    fun getAllUsuarios(): List<UsuarioEntity>
    fun addUsuario(usuarioEntity: UsuarioEntity)
    fun getUsuario(correoId: String): UsuarioEntity
    fun updateUsuario(usuarioEntity: UsuarioEntity)

    fun getAllIncidencias(): List<IncidenciaEntity>
    fun addIncidencia(incidenciaEntity: IncidenciaEntity)
    fun getIncidencia(incidenciaId: Int): IncidenciaEntity
    fun updateIncidencia(incidenciaEntity: IncidenciaEntity)

    fun getUsuarioWithIncidencias(): List<UsuarioWithIncidencias>

}