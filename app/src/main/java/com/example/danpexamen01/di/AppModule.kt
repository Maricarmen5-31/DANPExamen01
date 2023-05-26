package com.example.danpexamen01.di

import android.content.Context
import androidx.room.Room
import com.example.danpexamen01.data.network.AppDatabase
import com.example.danpexamen01.data.repository.RepositoryImpl
import com.example.danpexamen01.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

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
        "Seguridad.db"
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
    fun provideRepository(
        appDatabase: AppDatabase,
    ): Repository = RepositoryImpl(
        appDatabase  = appDatabase
    )
}
