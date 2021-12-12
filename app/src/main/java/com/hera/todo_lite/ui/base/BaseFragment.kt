package com.hera.todo_lite.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM: ViewModel>(contentViewId: Int) : Fragment(contentViewId) {

    abstract val viewModel: VM
}