package com.example.todo_notes.dailogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment(val callback: (Long) -> Unit) : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val  calender = Calendar.getInstance()
        val  hour = calender.get(Calendar.HOUR)
        val  minute = calender.get(Calendar.MINUTE)
        return TimePickerDialog(requireActivity(),this,hour,minute,false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val calender = Calendar.getInstance()
        calender.set(0,0,0, hourOfDay, minute)
        callback(calender.timeInMillis)
    }
}