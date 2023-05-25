package com.example.danpexamen01.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.danpexamen01.core.Constantes.Companion.INCIDENCIA_TABLE
import com.example.danpexamen01.domain.model.IncidenciaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IncidenciaDao {
    @Query("SELECT * FROM $INCIDENCIA_TABLE")
    fun getIncidencias(): Flow<IncidenciaEntity>

    @Query("SELECT * FROM $INCIDENCIA_TABLE WHERE incidenciaId = :incidenciaId")
    fun getIncidencia(incidenciaId: Int): IncidenciaEntity

    @Insert
    fun addIncidencia(incidenciaEntity: IncidenciaEntity)

    @Update
    fun updateIncidencia(incidenciaEntity: IncidenciaEntity)

    @Delete
    fun deleteIncidencia(incidenciaEntity: IncidenciaEntity)
}