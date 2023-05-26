package com.example.danpexamen01.interfaces

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.danpexamen01.domain.model.IncidenciaEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.danpexamen01.core.Constantes.Companion.NO_VALUE
import com.example.danpexamen01.domain.model.UsuarioEntity
import com.example.danpexamen01.domain.repository.Repository

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    var incidencia by mutableStateOf(IncidenciaEntity(0, NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE))
    val incidencias = repository.getAllIncidencias()
    var usuario by mutableStateOf(UsuarioEntity(NO_VALUE,NO_VALUE,NO_VALUE,NO_VALUE))

    fun addIncidencia(incidenciaEntity: IncidenciaEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.addIncidencia(incidenciaEntity)
    }
    fun getIncidencia(incidenciaId: Int) = viewModelScope.launch(Dispatchers.IO){
        incidencia = repository.getIncidencia(incidenciaId)
    }
    fun addUsuario(usuarioEntity: UsuarioEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.addUsuario(usuarioEntity)
    }
    fun getUsuario(correoId: String) = viewModelScope.launch(Dispatchers.IO){
        usuario = repository.getUsuario(correoId)
    }
}