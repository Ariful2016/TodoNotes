package com.example.todo_notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todo_notes.dailogs.DatePickerFragment
import com.example.todo_notes.dailogs.TimePickerFragment
import com.example.todo_notes.dailogs.ValidationDialogFragment
import com.example.todo_notes.databinding.FragmentTodoInsertBinding
import com.example.todo_notes.db.TodoDB
import com.example.todo_notes.entities.TodoModel
import com.example.todo_notes.viewModels.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoInsertFragment : Fragment() {

    lateinit var binding : FragmentTodoInsertBinding
    var priority = priority_normal
    var dateInMillis = System.currentTimeMillis()
    var timeInMillis = System.currentTimeMillis()

    private val  todoViewModel : TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentTodoInsertBinding.inflate(inflater)

        //todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)
       /* val todoServiceLocator = (requireActivity().application as TodoApplication).todoServiceLocator
        todoViewModel.repository = todoServiceLocator.repository*/

        binding.Rgroup.setOnCheckedChangeListener { group, checkedId ->
            var  rb : RadioButton = group.findViewById(checkedId)
            priority = rb.text.toString()
            Toast.makeText(activity,priority, Toast.LENGTH_SHORT).show()
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

        binding.submitBtn.setOnClickListener {
            val edit_txt = binding.editTxt.text.toString()
            if (edit_txt.isEmpty()){
                ValidationDialogFragment().show(childFragmentManager, "validate");
            }else{
                //ValidationDialogFragment().dismiss()
                val todo = TodoModel(name = edit_txt, priority = priority, date = dateInMillis, time = timeInMillis)
                todoViewModel.addTodo(todo)
                Toast.makeText(activity,"Information saved successfully", Toast.LENGTH_SHORT).show()
                // Log.e("TAG", todo.toString() )
                findNavController().navigate(R.id.action_todoInsertFragment_to_todo_Home_Fragment)
            }


        }

        return binding.root
    }


}