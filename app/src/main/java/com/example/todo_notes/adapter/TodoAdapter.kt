package com.example.todo_notes.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_notes.EditFragment
import com.example.todo_notes.R
import com.example.todo_notes.databinding.ItemTodoBinding
import com.example.todo_notes.entities.TodoModel
import com.example.todo_notes.todo_delete
import com.example.todo_notes.todo_edit

class TodoAdapter(val actionCallBack : (TodoModel, String) -> Unit) : ListAdapter<TodoModel, TodoAdapter.TodoViewHolder>(TodoDiffCallBack()) {

    lateinit var binding : ItemTodoBinding

    class TodoViewHolder(
        private val binding: ItemTodoBinding,
        val actionCallBack: (TodoModel, String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(todoModel: TodoModel){
            binding.todo = todoModel
            binding.itemChecked.setOnClickListener {
               actionCallBack(todoModel, todo_edit)
            }
            binding.itemDelete.setOnClickListener {
               actionCallBack(todoModel, todo_delete)
            }

            binding.itemEdit.setOnClickListener{

                val bundle = Bundle()
                bundle.putString("text",todoModel.name.toString())
                bundle.putString("priority",todoModel.priority)
                bundle.putString("date",todoModel.date.toString())
                bundle.putString("time",todoModel.time.toString())


               it.findNavController().navigate(R.id.action_todo_Home_Fragment_to_editFragment,bundle)


            }





        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding, actionCallBack)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val todoModel = getItem(position)
        holder.bind(todoModel)

    }

}

private class TodoDiffCallBack : DiffUtil.ItemCallback<TodoModel>(){
    override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {

       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem == newItem
    }

}