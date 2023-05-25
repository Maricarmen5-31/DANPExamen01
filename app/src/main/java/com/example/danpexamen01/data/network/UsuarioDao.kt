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
    fun getUsuarios(): List<UsuarioEntity>

    @Query("SELECT * FROM $USUARIO_TABLE WHERE correoId = :correoId")
    fun getUsuario(correoId: String): UsuarioEntity

    @Transaction
    @Query("SELECT * FROM $USUARIO_TABLE")
    fun getUsuarioWithIncidencias(): List<UsuarioWithIncidencias>

    @Insert
    fun addUsuario(usuarioEntity: UsuarioEntity)

    @Update
    fun updateUsuario(usuarioEntity: UsuarioEntity)

    @Delete
    fun deleteUsuario(usuarioEntity: UsuarioEntity)
}