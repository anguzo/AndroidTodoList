package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding

class TodoAdapter(private val todos: MutableList<Todo>) :
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { todo -> todo.isChecked }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        // with returns kotlin.Unit
        with(holder) {
            val currentTodo = todos[position]
            binding.tvTodoTitle.text = currentTodo.title
            binding.cbDone.isChecked = currentTodo.isChecked
            toggleStrikeThrough(binding.tvTodoTitle, currentTodo.isChecked)
            binding.cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(binding.tvTodoTitle, isChecked)
                currentTodo.isChecked = !currentTodo.isChecked
            }
        }

        // apply returns I/System.out: TodoViewHolder{3858023 position=0 id=-1, oldPos=-1, pLpos:-1 no parent}
//        holder.apply {
//            val currentTodo = todos[position]
//            binding.tvTodoTitle.text = currentTodo.title
//            binding.cbDone.isChecked = currentTodo.isChecked
//            toggleStrikeThrough(binding.tvTodoTitle, currentTodo.isChecked)
//            binding.cbDone.setOnCheckedChangeListener { _, isChecked ->
//                toggleStrikeThrough(binding.tvTodoTitle, isChecked)
//                currentTodo.isChecked = !currentTodo.isChecked
//            }
//        }
    }
}