package com.example.danpexamen01.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.danpexamen01.core.Constantes.Companion.INCIDENCIA_TABLE
import com.example.danpexamen01.domain.model.IncidenciaEntity

@Dao
interface IncidenciaDao {
    @Query("SELECT * FROM $INCIDENCIA_TABLE")
    suspend fun getIncidencias(): List<IncidenciaEntity>

    @Query("SELECT * FROM $INCIDENCIA_TABLE WHERE incidenciaId = :incidenciaId")
    suspend fun getIncidencia(incidenciaId: Int): IncidenciaEntity

    @Insert
    suspend fun addIncidencia(incidenciaEntity: IncidenciaEntity)

    @Update
    suspend fun updateIncidencia(incidenciaEntity: IncidenciaEntity)

    @Delete
    suspend fun deleteIncidencia(incidenciaEntity: IncidenciaEntity)
}