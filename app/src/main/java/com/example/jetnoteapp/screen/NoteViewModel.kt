package com.example.jetnoteapp.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnoteapp.data.NotesDataSource
import com.example.jetnoteapp.model.Note
import com.example.jetnoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()
    // private var noteList = mutableStateListOf<Note>()

    init{
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect{
                    listofNotes ->
                    if (listofNotes.isNullOrEmpty()){
                        Log.d("Empty", ": Empty List")
                    }else{
                        _noteList.value = listofNotes
                    }
                }
        }
        //noteList.addAll(NotesDataSource().loadNotes())
    }

     fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

     fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

     fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }


}