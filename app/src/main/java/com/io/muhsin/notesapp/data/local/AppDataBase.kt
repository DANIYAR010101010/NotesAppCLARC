package com.io.muhsin.notesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.io.muhsin.notesapp.data.local.dao.NoteRepositoryImpl
import com.io.muhsin.notesapp.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteRepositoryImpl
}