package com.example.todo_notes.dailogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.todo_notes.R

class DeleteAlertDialog(val callBack:() ->Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Delete")
        builder.setIcon(R.drawable.ic_baseline_delete_24)
        builder.setMessage("Are you sure to delete?")
        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            callBack()
        } )
        builder.setNegativeButton("Cancel", null)
        return builder.create()
    }
}