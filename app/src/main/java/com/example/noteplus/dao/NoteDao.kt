package com.example.noteplus.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteplus.Entity.Notes


@Dao
interface NoteDao {

    @Query("select * from Notes ORDER BY id DESC")
    suspend fun getAllNotes():List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Notes)

    @Delete
    suspend fun delete(note:Notes)

}