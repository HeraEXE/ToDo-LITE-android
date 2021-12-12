package com.hera.todo_lite.ui.edit_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hera.todo_lite.R
import com.hera.todo_lite.databinding.FragmentEditTaskBinding
import com.hera.todo_lite.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditTaskFragment :
    BaseFragment<EditTaskViewModel>(R.layout.fragment_edit_task) {

    override val viewModel: EditTaskViewModel by viewModels()
    private val args: EditTaskFragmentArgs by navArgs()
    private var _binding: FragmentEditTaskBinding? = null
    private val binding: FragmentEditTaskBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditTaskBinding.bind(view)
        binding.apply {
            editTextTitle.setText(args.task.title)
            editTextDescription.setText(args.task.description)
            fabEditTask.setOnClickListener {
                onEditTask()
            }
        }
    }

    private fun onEditTask() {
        val title: String = binding.editTextTitle.text.toString()
        val description: String = binding.editTextTitle.text.toString()
        if (title.isNotEmpty() && description.isNotEmpty()) {
            val task = args.task.copy(title = title, description = description)
            viewModel.editTask(task)
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}