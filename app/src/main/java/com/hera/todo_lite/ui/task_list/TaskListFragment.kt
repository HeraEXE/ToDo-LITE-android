package com.hera.todo_lite.ui.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hera.todo_lite.R
import com.hera.todo_lite.data.model.Task
import com.hera.todo_lite.databinding.FragmentTaskListBinding
import com.hera.todo_lite.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskListFragment : BaseFragment<TaskListViewModel>(R.layout.fragment_task_list), TaskListAdapter.Listener {

    override val viewModel: TaskListViewModel by viewModels()

    private val taskListAdapter: TaskListAdapter = TaskListAdapter(this)

    private var _binding: FragmentTaskListBinding? = null
    private val binding: FragmentTaskListBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTaskListBinding.bind(view)
        binding.apply {
            recyclerTaskList.layoutManager = LinearLayoutManager(requireContext())
            recyclerTaskList.adapter = taskListAdapter
            fabCreateTask.setOnClickListener {
                // TODO create AddTaskFragment
            }
        }
    }

    override fun onCheckBoxClick(updatedTask: Task) {
        viewModel.editTask(updatedTask)
    }

    override fun onItemClick(task: Task) {
        // TODO create EditTaskFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}