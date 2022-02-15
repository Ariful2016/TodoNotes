package com.example.todo_notes.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todo_notes.entities.TodoModel

@Dao
interface TodoDao {
    @Insert
    suspend fun addTodo(todoModel: TodoModel)

    @Update
    suspend fun updateTodo(todoModel: TodoModel)

    @Delete
    suspend fun deleteTodo(todoModel: TodoModel)

    @Query("select * from tbl_todo order by id desc")
    fun getAllTodos(): LiveData<List<TodoModel>>
}
