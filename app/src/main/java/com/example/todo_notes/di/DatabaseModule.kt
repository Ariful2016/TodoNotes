package com.example.todo_notes.di

import android.content.Context
import com.example.todo_notes.dao.TodoDao
import com.example.todo_notes.db.TodoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao {
        return TodoDB.getDb(context).todoDao()
    }
}