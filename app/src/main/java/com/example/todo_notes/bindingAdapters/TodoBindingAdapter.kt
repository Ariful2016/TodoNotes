package com.example.todo_notes.bindingAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo_notes.R
import com.example.todo_notes.getFormattedDateTime
import com.example.todo_notes.priority_high
import com.example.todo_notes.priority_normal

@BindingAdapter( "app:setPriorityIcon" )
fun setPriorityIcon (iv : ImageView, priority : String){

    val icon = when (priority){
        priority_high -> R.drawable.ic_priority_high
        priority_normal -> R.drawable.ic_prioraty_normal
        else -> R.drawable.ic_prioraty_law
    }

    iv.setImageResource(icon)
}

@BindingAdapter("app:setFormattedDate")
fun setFormattedDate(tv : TextView, date : Long){

    tv.text = getFormattedDateTime(date,"dd/MM/yyyy")
}

@BindingAdapter("app:setFormattedTime")
fun setFormattedRime(tv : TextView, time : Long){

    tv.text = getFormattedDateTime(time,"hh:mm a")
}