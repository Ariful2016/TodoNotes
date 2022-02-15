package com.example.todo_notes.dailogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.todo_notes.R

class ValidationDialogFragment() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Text field can't be empty!")
        builder.setIcon(R.drawable.ic_baseline_error_24)
        builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->

        } )

        return builder.create()

    }
}