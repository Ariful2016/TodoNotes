package com.example.todo_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todo_notes.adapter.TodoAdapter
import com.example.todo_notes.dailogs.DeleteAlertDialog
import com.example.todo_notes.dailogs.ValidationDialogFragment
import com.example.todo_notes.databinding.FragmentTodoHomeBinding
import com.example.todo_notes.entities.TodoModel
import com.example.todo_notes.viewModels.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoHomeFragment : Fragment() {

    lateinit var binding: FragmentTodoHomeBinding

    private val todoViewModel: TodoViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoHomeBinding.inflate(inflater)

        //todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)
       /* val todoServiceLocator = (requireActivity().application as TodoApplication).todoServiceLocator
        todoViewModel.repository = todoServiceLocator.repository*/

        val adapter = TodoAdapter(::todoAction)

        binding.recyclerlist.adapter = adapter
        todoViewModel.getTodos().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_todo_Home_Fragment_to_todoInsertFragment)
        }
        return binding.root
    }

    private fun todoAction( todoModel: TodoModel, tag : String ){
        when (tag){
            todo_edit -> todoViewModel.updateTodo(todoModel)
            todo_delete -> {
                DeleteAlertDialog{
                    todoViewModel.deleteTodo(todoModel)
                }.show(childFragmentManager, "delete")
            }

        }
    }



}