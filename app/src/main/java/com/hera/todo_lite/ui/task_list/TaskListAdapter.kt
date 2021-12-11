package com.hera.todo_lite.ui.task_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hera.todo_lite.data.model.Task
import com.hera.todo_lite.databinding.ItemTaskBinding

class TaskListAdapter(private val listener: Listener) :
    ListAdapter<Task, TaskListAdapter.ViewHolder>(DiffCallback()) {

    interface Listener {

        fun onCheckBoxClick(updatedTask: Task)

        fun onItemClick(task: Task)
    }

    inner class ViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun initView(task: Task) {
            binding.apply {
                taskCheckBox.isChecked = task.isDone
                taskTitle.text = task.title
                taskCV.setOnClickListener { listener.onItemClick(task) }
                taskCheckBox.setOnClickListener { listener.onCheckBoxClick(task.copy(isDone = !task.isDone)) }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Task>() {

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTaskBinding =
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task: Task = currentList[position]
        holder.initView(task)
    }
}