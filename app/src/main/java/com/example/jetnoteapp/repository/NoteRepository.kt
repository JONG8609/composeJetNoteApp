package com.example.jetnoteapp.repository

import com.example.jetnoteapp.data.NoteDatabaseDao
import com.example.jetnoteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()
    suspend fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNote().flowOn(Dispatchers.IO)
        .conflate()
}