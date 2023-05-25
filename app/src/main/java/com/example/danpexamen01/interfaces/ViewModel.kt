package com.example.danpexamen01.interfaces

import androidx.lifecycle.ViewModel
import com.example.danpexamen01.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repo: RepositoryImpl
): ViewModel(){

    val incidencias = repo.getAllIncidencias()

}