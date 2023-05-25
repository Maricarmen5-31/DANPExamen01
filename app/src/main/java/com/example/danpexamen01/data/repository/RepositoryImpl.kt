package com.example.danpexamen01.data.repository

import com.example.danpexamen01.data.network.AppDatabase
import com.example.danpexamen01.domain.model.IncidenciaEntity
import com.example.danpexamen01.domain.repository.Repository
import com.example.danpexamen01.domain.model.UsuarioEntity

class RepositoryImpl(
    private val appDatabase: AppDatabase
): Repository{

    override suspend fun getAllUsuarios() = appDatabase.usuarioDao().getUsuarios()
    override suspend fun addUsuario(usuarioEntity: UsuarioEntity) = appDatabase.usuarioDao().addUsuario(usuarioEntity)
    override suspend fun getUsuario(correoId: String) = appDatabase.usuarioDao().getUsuario(correoId)
    override suspend fun updateUsuario(usuarioEntity: UsuarioEntity) = appDatabase.usuarioDao().updateUsuario(usuarioEntity)

    override suspend fun getAllIncidencias() = appDatabase.incidenciaDao().getIncidencias()
    override suspend fun addIncidencia(incidenciaEntity: IncidenciaEntity) = appDatabase.incidenciaDao().addIncidencia(incidenciaEntity)
    override suspend fun getIncidencia(incidenciaId: Int) = appDatabase.incidenciaDao().getIncidencia(incidenciaId)
    override suspend fun updateIncidencia(incidenciaEntity: IncidenciaEntity) = appDatabase.incidenciaDao().updateIncidencia(incidenciaEntity)

    override suspend fun getUsuarioWithIncidencias() = appDatabase.usuarioDao().getUsuarioWithIncidencias()

}