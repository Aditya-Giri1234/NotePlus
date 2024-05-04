package com.example.noteplus.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteplus.Entity.Notes
import com.example.noteplus.dao.NoteDao

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase :RoomDatabase() {

    companion object{
        private var INSTANCE:NotesDatabase?=null

        @Synchronized
        fun getDatabase(context: Context):NotesDatabase{
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,NotesDatabase::class.java,"notes.db").build()
            }
            return INSTANCE!!

        }
    }

    abstract fun getDao():NoteDao

}