package com.example.todo_notes.repository

import androidx.lifecycle.LiveData
import com.example.todo_notes.dao.TodoDao
import com.example.todo_notes.entities.TodoModel
import javax.inject.Inject

class TodoLocalRepository @Inject constructor(val dao : TodoDao) {

    suspend fun addTodo(todoModel: TodoModel){
        dao.addTodo(todoModel)
    }
    suspend fun updateTodo(todoModel: TodoModel){
        dao.updateTodo(todoModel)
    }
    suspend fun deleteTodo(todoModel: TodoModel){
        dao.deleteTodo(todoModel)
    }

    fun getAllTodos() : LiveData<List<TodoModel>>{

        return dao.getAllTodos()
    }
}