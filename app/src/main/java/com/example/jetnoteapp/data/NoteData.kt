package com.example.jetnoteapp.data

import com.example.jetnoteapp.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "A good day", description = "We want on a vacation"),
            Note(title = "B good day", description = "We want on a vacation"),
            Note(title = "C good day", description = "We want on a vacation"),
            Note(title = "D good day", description = "We want on a vacation"),
            Note(title = "E good day", description = "We want on a vacation"),
            Note(title = "F good day", description = "We want on a vacation"),
            Note(title = "G good day", description = "We want on a vacation"),
            Note(title = "H good day", description = "We want on a vacation"),
            Note(title = "I good day", description = "We want on a vacation"),
            Note(title = "J good day", description = "We want on a vacation")

            )
    }
}