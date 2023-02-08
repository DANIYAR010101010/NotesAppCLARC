package com.io.muhsin.notesapp.domain.usecase

import com.io.muhsin.notesapp.domain.model.Note
import com.io.muhsin.notesapp.domain.repository.NoteRepository
import javax.inject.Inject


class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.insertNote(note = note)
}