package com.example.todo_notes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo_notes.dao.TodoDao
import com.example.todo_notes.entities.TodoModel

@Database(entities = [TodoModel::class], version = 1)
abstract class TodoDB : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object{
        private var db : TodoDB? = null

        fun getDb(context: Context) : TodoDB{

            return db ?: synchronized(this){

                val _db = Room.databaseBuilder(
                    context,
                    TodoDB::class.java,
                    "todo_db"
                )//.allowMainThreadQueries()
                    .build()
                db = _db
                _db
            }
        }
    }



}