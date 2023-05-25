package com.example.danpexamen01.data.repository

import com.example.danpexamen01.data.network.AppDatabase
import com.example.danpexamen01.domain.model.IncidenciaEntity
import com.example.danpexamen01.domain.repository.Repository
import com.example.danpexamen01.domain.model.UsuarioEntity

typealias Incidencias = List<IncidenciaEntity>
class RepositoryImpl(
    private val appDatabase: AppDatabase
): Repository{

    override fun getAllUsuarios() = appDatabase.usuarioDao().getUsuarios()
    override fun addUsuario(usuarioEntity: UsuarioEntity) = appDatabase.usuarioDao().addUsuario(usuarioEntity)
    override fun getUsuario(correoId: String) = appDatabase.usuarioDao().getUsuario(correoId)
    override fun updateUsuario(usuarioEntity: UsuarioEntity) = appDatabase.usuarioDao().updateUsuario(usuarioEntity)

    override fun getAllIncidencias() = appDatabase.incidenciaDao().getIncidencias()
    override fun addIncidencia(incidenciaEntity: IncidenciaEntity) = appDatabase.incidenciaDao().addIncidencia(incidenciaEntity)
    override fun getIncidencia(incidenciaId: Int) = appDatabase.incidenciaDao().getIncidencia(incidenciaId)
    override fun updateIncidencia(incidenciaEntity: IncidenciaEntity) = appDatabase.incidenciaDao().updateIncidencia(incidenciaEntity)

    override fun getUsuarioWithIncidencias() = appDatabase.usuarioDao().getUsuarioWithIncidencias()

}