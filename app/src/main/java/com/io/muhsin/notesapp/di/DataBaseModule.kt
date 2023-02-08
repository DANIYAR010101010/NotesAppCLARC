package com.io.muhsin.notesapp.di

import android.content.Context
import androidx.room.Room
import com.io.muhsin.notesapp.data.local.AppDatabase
import com.io.muhsin.notesapp.data.local.dao.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideAppDate(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "notes_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(appDatabase: AppDatabase): NoteRepositoryImpl {
        return appDatabase.noteDao()
    }
}