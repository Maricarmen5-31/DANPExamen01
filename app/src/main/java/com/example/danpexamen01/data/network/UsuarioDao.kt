package com.example.danpexamen01.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.danpexamen01.domain.model.UsuarioEntity
import com.example.danpexamen01.core.Constantes.Companion.USUARIO_TABLE
import com.example.danpexamen01.domain.model.UsuarioWithIncidencias

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM $USUARIO_TABLE")
    suspend fun getUsuarios(): List<UsuarioEntity>

    @Query("SELECT * FROM $USUARIO_TABLE WHERE correoId = :correoId")
    suspend fun getUsuario(correoId: String): UsuarioEntity

    @Transaction
    @Query("SELECT * FROM $USUARIO_TABLE")
    suspend fun getUsuarioWithIncidencias(): List<UsuarioWithIncidencias>

    @Insert
    suspend fun addUsuario(usuarioEntity: UsuarioEntity)

    @Update
    suspend fun updateUsuario(usuarioEntity: UsuarioEntity)

    @Delete
    suspend fun deleteUsuario(usuarioEntity: UsuarioEntity)
}