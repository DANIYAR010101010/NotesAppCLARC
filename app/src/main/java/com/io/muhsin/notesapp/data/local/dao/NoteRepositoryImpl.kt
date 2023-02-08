package com.io.muhsin.notesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.io.muhsin.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteRepositoryImpl {

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<Note>

    @Insert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note WHERE id=:nodeId")
    suspend fun getNoteById(nodeId: Long)

}