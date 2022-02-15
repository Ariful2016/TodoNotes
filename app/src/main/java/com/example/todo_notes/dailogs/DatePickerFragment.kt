package com.example.todo_notes.dailogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*
import javax.security.auth.callback.Callback

class DatePickerFragment( val callback: (Long) -> Unit) : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val  calender = Calendar.getInstance()
        val  year = calender.get(Calendar.YEAR)
        val  month = calender.get(Calendar.MONTH)
        val  dayOfMonth = calender.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(),this,year,month,dayOfMonth)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calender = Calendar.getInstance()
        calender.set(year,month,dayOfMonth)
        callback(calender.timeInMillis)
    }
}