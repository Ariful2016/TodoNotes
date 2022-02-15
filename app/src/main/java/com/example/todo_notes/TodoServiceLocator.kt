package com.example.todo_notes.repository

import android.content.Context
import com.example.todo_notes.db.TodoDB

class TodoServiceLocator(context: Context) {

     val repository = TodoLocalRepository(TodoDB.getDb(context).todoDao())
}