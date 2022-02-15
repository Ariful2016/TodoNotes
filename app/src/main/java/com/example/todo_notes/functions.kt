package com.example.todo_notes

import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDateTime(millies: Long, format: String) =
    SimpleDateFormat(format, Locale.getDefault()).format(Date(millies))
