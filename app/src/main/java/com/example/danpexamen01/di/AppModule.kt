package com.example.danpexamen01.di

import android.content.Context
import androidx.room.Room
import com.example.danpexamen01.core.Constantes.Companion.INCIDENCIA_TABLE
import com.example.danpexamen01.core.Constantes.Companion.USUARIO_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.danpexamen01.data.network.AppDatabase
import com.example.danpexamen01.data.repository.RepositoryImpl
import com.example.danpexamen01.domain.repository.Repository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideUsuarioDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        USUARIO_TABLE
    ).build()

    @Provides
    fun provideIncicenciaDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        INCIDENCIA_TABLE
    ).build()


    @Provides
    fun provideUsuarioDao(
        appDatabase: AppDatabase
    ) = appDatabase.usuarioDao()

    @Provides
    fun provideIncidenciaDao(
        appDatabase: AppDatabase
    ) = appDatabase.incidenciaDao()


    @Provides
    fun provideUsuarioRepository(
        usuarioDao: AppDatabase
    ): Repository = RepositoryImpl(
        appDatabase = usuarioDao
    )

    @Provides
    fun provideIncidenciaRepository(
        incidenciaDao: AppDatabase
    ): Repository = RepositoryImpl(
        appDatabase = incidenciaDao
    )
}