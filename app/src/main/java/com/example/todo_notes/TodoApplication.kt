package com.example.todo_notes

import android.app.Application
import com.example.todo_notes.repository.TodoServiceLocator
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApplication : Application() {
    /*lateinit var todoServiceLocator: TodoServiceLocator
    override fun onCreate() {
        super.onCreate()
        todoServiceLocator = TodoServiceLocator(applicationContext)

    }*/
}