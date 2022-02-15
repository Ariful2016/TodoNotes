package com.example.todo_notes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_notes.dailogs.DatePickerFragment
import com.example.todo_notes.dailogs.TimePickerFragment
import com.example.todo_notes.dailogs.ValidationDialogFragment
import com.example.todo_notes.databinding.FragmentEditBinding
import com.example.todo_notes.databinding.FragmentTodoInsertBinding
import com.example.todo_notes.entities.TodoModel
import com.example.todo_notes.viewModels.TodoViewModel
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : Fragment() {

    lateinit var binding : FragmentEditBinding

    var priority = arguments?.getString("priority").toString()
    var dateInMillis = System.currentTimeMillis()
    var timeInMillis = System.currentTimeMillis()

    private val  todoViewModel : TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)

        var name = arguments?.getString("text").toString()
        //var date = arguments?.getString("date").toString()
       // var time = arguments?.getString("time").toString()

        binding.editTxt.setText(name)
       // binding.dateBtn.setText(getFormattedDateTime(date.toLong(),"dd/MM/yyyy"))
        //binding.timeBtn.setText(getFormattedDateTime(time.toLong(),"hh:mm a"))

        var editTextNew =  binding.editTxt.text.toString()

        binding.Rgroup.setOnCheckedChangeListener { group, checkedId ->
            var  rb : RadioButton = group.findViewById(checkedId)
            priority = rb.text.toString()
        }

        binding.dateBtn.setOnClickListener {

            DatePickerFragment {
                dateInMillis = it
                binding.dateBtn.text = getFormattedDateTime(it, "dd/MM/yyyy")
            }.show(childFragmentManager,"date_picker ");
        }
        binding.timeBtn.setOnClickListener {
            TimePickerFragment{
                timeInMillis = it
                binding.timeBtn.text = getFormattedDateTime(it,"hh:mm a")
            }.show(childFragmentManager,"Time_Picker")
        }

        binding.updateBtn.setOnClickListener {
            val edit_txt = editTextNew.toString()
            if (edit_txt.isEmpty()){
                ValidationDialogFragment().show(childFragmentManager, "validate");
            }else{
                //ValidationDialogFragment().dismiss()
                val todo = TodoModel(name = edit_txt, priority = priority, date = dateInMillis, time = timeInMillis)
                todoViewModel.updateTodo(todo)
                Toast.makeText(activity,"Information update successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editFragment_to_todo_Home_Fragment)
            }


        }






        return binding.root
    }


}