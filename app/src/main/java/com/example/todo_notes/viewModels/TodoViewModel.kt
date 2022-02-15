package com.example.todo_notes.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_notes.entities.TodoModel
import com.example.todo_notes.repository.TodoLocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(val repository : TodoLocalRepository) : ViewModel() {
   // lateinit var repository : TodoLocalRepository

    fun addTodo(todoModel: TodoModel){
       viewModelScope.launch {
           repository.addTodo(todoModel)
       }
    }
    fun updateTodo(todoModel: TodoModel){
        todoModel.isCompleted = !todoModel.isCompleted
       // todoModel.name = todoModel.name.toString()
        viewModelScope.launch {
            repository.updateTodo(todoModel)
        }
    }
    fun deleteTodo(todoModel: TodoModel){
       viewModelScope.launch {
           repository.deleteTodo(todoModel)
       }
    }
    fun getTodos() : LiveData<List<TodoModel>> = repository.getAllTodos()

}