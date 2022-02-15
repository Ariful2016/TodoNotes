package com.example.todo_notes.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_todo")
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long =0,
    var name: String,
    var priority: String,
    var date: Long,
    var time: Long,
    @ColumnInfo(name = "completed")
    var isCompleted: Boolean = false

)
