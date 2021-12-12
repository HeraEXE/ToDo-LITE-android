package com.hera.todo_lite.ui.create_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hera.todo_lite.R
import com.hera.todo_lite.data.model.Task
import com.hera.todo_lite.databinding.FragmentCreateTaskBinding
import com.hera.todo_lite.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTaskFragment :
    BaseFragment<CreateTaskViewModel>(R.layout.fragment_create_task) {

    override val viewModel: CreateTaskViewModel by viewModels()

    private var _binding: FragmentCreateTaskBinding? = null
    private val binding: FragmentCreateTaskBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCreateTaskBinding.bind(view)
        binding.fabCreateTask.setOnClickListener { onCreateTask() }
    }

    private fun onCreateTask() {
        val title: String = binding.editTextTitle.text.toString()
        val description: String = binding.editTextDescription.text.toString()
        if (title.isNotEmpty() && description.isNotEmpty()) {
            viewModel.createTask(Task(title, description))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}