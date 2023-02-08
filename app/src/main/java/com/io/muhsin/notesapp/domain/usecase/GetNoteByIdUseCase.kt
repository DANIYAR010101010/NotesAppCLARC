package com.io.muhsin.notesapp.domain.usecase

import com.io.muhsin.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Long) = noteRepository.getNoteById(id = id)
}